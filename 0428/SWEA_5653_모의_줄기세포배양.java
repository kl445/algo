package algo.hw0429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5653_모의_줄기세포배양 {
	
	static class Cell{
		int i; //i세로좌표
		int j; //j가로좌표
		int x; //x 줄기세포의 생명력(처음 입력값 보관)
		
		int life; //활성화까지시간 -> 살아있는시간
		int time; // 배양시간
		int flag; // 황성화상태
		
		public Cell(int i, int j, int x, int life, int time, int flag) {
			this.i = i;
			this.j = j;
			this.x = x;
			this.life = life;
			this.time = time;
			this.flag = flag;
		}
		
		
	}

	static int N, M, K;
	static int[][] map;
	static List<ArrayList<Cell>> list;//줄기세포 생명력 (1<=x<=10) 별 저장(인덱스0~9)사용
	static int[] di= {-1,1,0,0};
	static int[] dj= {0,0,-1,1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		list=new ArrayList<>();
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb=new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			list.clear();
			for (int x = 0; x <=9; x++) {//줄기세포 생명력 1<=x<=10
				list.add(new ArrayList<>());
			}		
			N=sc.nextInt();
			M=sc.nextInt();
			K=sc.nextInt();
			
			map=new int[N+K][M+K];
			
			for (int i = (K/2); i < N+(K/2); i++) { //배열의 중간 계산
				for (int j =(K/2); j < (K/2)+M; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]!=0) {
						int idx=map[i][j]-1;
						list.get(idx).add(new Cell(i, j, map[i][j], map[i][j], K, 0));
						//i: 세로 j:가로 x:줄기세포 생명력, life:활성화시간 time
					}
				}
			}
			
			bfs();
			
			int cnt=0;
			for (int i = 0; i < N+K; i++) {
				for (int j = 0; j < M+K; j++) {
					if(map[i][j]!=0 && map[i][j]!=-1) cnt++;
				}
			}
			sb.append(cnt);
			System.out.println(sb.toString());
		}
	}

	private static void bfs() {
		Queue<Cell> q=new LinkedList<>();
		
		for (int x = 9; x>=0; x--) {
			for(int s=0; s<list.get(x).size();s++){
				q.offer(list.get(x).get(s));
			}
		}
		
		while(!q.isEmpty()) {
			Cell c=q.poll();
			if(c.life==0 && c.flag==1) {
				map[c.i][c.j]=-1;
				continue; //종료처리
			}
			if(c.time==0) {
				continue;
			}
			if(c.life!=0) {
				q.offer(new Cell(c.i, c.j, c.x, c.life-1, c.time-1, c.flag));
				continue;
				
			}
			//c.life==0
			q.offer(new Cell(c.i, c.j, c.x, c.x, c.time, 1));
			for (int d = 0; d < 4; d++) {
				int ni= c.i+di[d];
				int nj= c.j+dj[d];
				if(0<=ni && ni<N+K && 0<=nj && nj<M+K && map[ni][nj]==0) {
					
					map[ni][nj]=c.x;	
					q.offer(new Cell(ni,nj, c.x, c.x, c.time-1, 0));
				}
			}
			
		}
		
	}

}
