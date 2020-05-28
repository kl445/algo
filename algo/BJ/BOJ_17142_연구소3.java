package algo.hw0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {

	static int N,M;
	static int[][] map;
	static int min;
	static int wall=0;
	static int total_virus=0;
	static int now_virus=0;
	static int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	
	static ArrayList<Pos> list=new ArrayList<>();
	
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk=new StringTokenizer(in.readLine());
		
		N=Integer.parseInt(tk.nextToken());
		M=Integer.parseInt(tk.nextToken());
		map=new int[N][N];
		min=Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			tk=new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(tk.nextToken());
				if(map[i][j]==2) {
					list.add(new Pos(i,j));
					total_virus++;
				}
				else if(map[i][j]==1) {
					wall++;
				}
			}
		}
		
		
		
		combi(0, 0, new int[M]);
		
		if(min==Integer.MAX_VALUE) {
			min=-1;
		}
		System.out.println(min);
		
		
		
	}

	static boolean isIn(int r,int c) {
		return(r<N && c<N && -1<r && -1<c);
	}
	
	private static void combi(int start,int idx,int[] temp) {
		if(idx==M) {
//			System.out.println(Arrays.toString(temp));
			now_virus=0;
			bfs(temp);
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			temp[idx]=i;
			combi(i+1, idx+1, temp);
		}
		
	}

	private static void bfs(int[] temp) {
		Queue<Pos> q=new LinkedList<>();
		
		boolean visited[][]=new boolean[N][N];
		
		for (int i = 0; i < temp.length; i++) {
			Pos idx=list.get(temp[i]);
			q.offer(idx);
			visited[idx.r][idx.c]=true;
		}
		
		int time=0;
		while(!q.isEmpty()) {
			
			if(total_virus+now_virus+wall==N*N) {
				break;
			}
			int qsize=q.size();
			for (int i = 0; i < qsize; i++) {
			
				Pos front=q.poll();
				
				for (int d = 0; d < dirs.length; d++) {
					int nr=front.r+dirs[d][0];
					int nc=front.c+dirs[d][1];
					
					
					if(isIn(nr, nc) && !visited[nr][nc]) {
						
						if(map[nr][nc]==0 ) {
							q.offer(new Pos(nr,nc));
							visited[nr][nc]=true;
							now_virus++;
						}
						else if(map[nr][nc]==2) {
							q.offer(new Pos(nr,nc));
							visited[nr][nc]=true;
						}
						else {
							visited[nr][nc]=true;
						}
						
						
					}
				}
				
				
				
			}
			
			time++;
			
			
			
			
		}
		if(total_virus+now_virus+wall==N*N) {
			min=Math.min(min, time);
		}
		
		
		
		
		
		
		
	}

}
