package algo.hw0528;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_모의_탈주범검거 {

	static int R,C;
	static int map[][];
	static int hole_R,hole_C;
	static int L;
	static int max;
	
	static int[][] dirs= {{-1,0},{0,1},{1,0},{0,-1}};
	
	
	static class Pos{
		int r;
		int c;
		int type;
		public Pos(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int TC=sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			R=sc.nextInt();
			C=sc.nextInt();
			
			map=new int[R][C];
			
			hole_R=sc.nextInt();
			hole_C=sc.nextInt();
			L=sc.nextInt();
			max=0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			Pos hole=new Pos(hole_R,hole_C,map[hole_R][hole_C]);
			
			bfs(hole);
			
			
			System.out.println("#"+tc+" "+max);
			
			
			
			
		}

	}
	
	static boolean isIn(int nr, int nc) {
		return(nr>-1 && nc>-1 && nr<R && nc<C);
	}
	
	static void printMap(boolean[][] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
		System.out.println("#########################");
	}
	private static void bfs(Pos hole) {
		
		boolean visited[][]=new boolean[R][C];
		
		Queue<Pos> que=new LinkedList<>();
		
		que.add(hole);
		max++;
		visited[hole.r][hole.c]=true;
		int time=1;
		
		while(!que.isEmpty()&&time!=L) {
			
			int q_size=que.size();
			
//			System.out.println("time:"+time+"max:"+max);
//			printMap(visited);
			for (int i = 0; i < q_size; i++) {
				
				Pos now=que.poll();
				
//				ArrayList<int[]> dirs=makedirs(now.type);
//				
//				for (int d = 0; d < dirs.size(); d++) {
//					int nr=now.r+dirs.get(d)[0];
//					int nc=now.c+dirs.get(d)[1];
				for (int d = 0; d < dirs.length; d++) {
					int nr=now.r+dirs[d][0];
					int nc=now.c+dirs[d][1];
					
					
					if(isIn(nr, nc) && !visited[nr][nc]) {
						
						if(isNext(now.type,map[nr][nc],d)) {
							que.offer(new Pos(nr,nc,map[nr][nc]));
							visited[nr][nc]=true;
							max++;
						}
						else {
							if(map[nr][nc]==0) {
//								visited[nr][nc]=true;
							}
						}
					}
				}
				
			}
			time++;
			
			
			
		}
		
		
	}

	private static boolean isNext(int type, int next_type,int way) {
		
		boolean[] now=getWay(type);
		boolean[] next=getWay(next_type);
		
		if(now[way]&&next[(way+2)%4]) {
			return true;
		}
		
		return false;
	}

	private static boolean[] getWay(int type) {
		 
		boolean[] way=new boolean[4];
		
		switch (type) {
		case 0:
			return way;
		case 1:
			for (int i = 0; i < way.length; i++) {
				way[i]=true;
			}
			return way;
		case 2:
			way[0]=true;
			way[2]=true;
			return way;
		case 3:
			way[1]=true;
			way[3]=true;
			return way;
		case 4:
			way[0]=true;
			way[1]=true;
			return way;
		case 5:
			way[1]=true;
			way[2]=true;
			return way;
		case 6:
			way[2]=true;
			way[3]=true;
			return way;
		case 7:
			way[3]=true;
			way[0]=true;
			return way;

		}
		
		return null;
	}

}
