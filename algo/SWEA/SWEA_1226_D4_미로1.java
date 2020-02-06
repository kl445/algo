package swea_0206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1226_D4_미로1 {

	
	//위치 좌표 클래스
	static class pos{
		int r;
		int c;
		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "pos [r=" + r + ", c=" + c + "]";
		}
	}
	
	//범위를 벗어나는지? 지나갈수 있는지?
	public static boolean isOk(int r, int c,int[][] map) {
		return(r>0 && c> 0 && r<map.length && c<map.length && map[r][c]!=1);
	}
	
	//움직일 방향
	private static int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			int tc= sc.nextInt();
			
			int map[][]=new int[16][16];
			
			// 맵 세팅
			for (int j = 0; j < map.length; j++) {
				String str=sc.next();
				for (int k = 0; k < map.length; k++) {
					map[j][k]=str.charAt(k)-'0';
				}
			}
//			for (int j = 0; j < map.length; j++) {
//				for (int k = 0; k < map.length; k++) {
//					System.out.print(map[j][k]);
//				}
//				System.out.println();
//			}
			
			Queue<pos> qu=new LinkedList<>();
		
			//시작 좌표
			int start_r=1,start_c=1;
			
			
			//큐에 시작좌표 삽입
			qu.offer(new pos(start_r,start_c));
			
			//출구에 갈 수 있는지
			int flag=0;
			
			//더 이상 갈 곳이 없을 때까지
			while(!qu.isEmpty()) {
				
				//다음 대기 좌표 부르기
				pos pos_temp=qu.poll();
				
				//불러낸 좌표가 목적지일 때 브레이크 
				if(map[pos_temp.r][pos_temp.c]==3) {
					flag=1;
					break;
				}
				
//				System.out.println("out"+pos_temp);
				
				//4방향에 대해 탐색
				for (int d = 0; d < dirs.length; d++) {
					//다음 좌표 세팅
					int nr=dirs[d][0]+pos_temp.r;
					int nc=dirs[d][1]+pos_temp.c;
					
					//갈 수 있다면?
						if(isOk(nr,nc,map)) {
							//큐 삽입
							qu.offer(new pos(nr,nc));
//							System.out.println("in"+nr+" : "+nc);
							//현재 좌표는 간곳 처리
							map[pos_temp.r][pos_temp.c]=1;
						}
				}
				
			
			}
			
			System.out.printf("#%d %d\n",tc,flag);
		}
		
	}

}
