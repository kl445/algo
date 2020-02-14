package swea_0213;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7576_토마토 {

	public static void printMap(int map[][]) {
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}
	
	public static boolean isAll(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static boolean isIn(int r, int c ,int map[][]) {
		return (r>-1 && c>-1 && r<map.length && c<map[0].length );
	}
	
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
	
	public static int day=0;
	
	
	public static void dayGo(int map[][]) {
		
		Queue<Pos> que=new LinkedList<>();
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]==1) {
					int r=i;
					int c=j;
					
					for (int d = 0; d < dirs.length; d++) {
						int nr=r+dirs[d][0];
						int nc=c+dirs[d][1];
						
						if(isIn(nr,nc,map)&&map[nr][nc]==0) {
							que.add(new Pos(nr,nc));
						}
					}
				}
				
				
			}
		}
		
		while(!que.isEmpty()) {
			Pos temp=que.poll();
			map[temp.r][temp.c]=1;
		}
		
		day++;
	}
	
	

	public static boolean isOk(int map[][]) {
		
		for (int i = 0; i < map.length; i++) {
			
			for (int j = 0; j < map[0].length; j++) {
				
				boolean flag= false;
				if(map[i][j]==0) {
					int z_r=i;
					int z_c=j;
					
					
					for (int d = 0; d < dirs.length; d++) {
						int nr=z_r+dirs[d][0];
						int nc=z_c+dirs[d][1];
						
						if(isIn(nr,nc,map)&&(map[nr][nc]==0||map[nr][nc]==1)) {
							flag=true;
						}
					}
					
					if(!flag) {
						return false;
					}
					
					
				}
			}
		}
		 return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int m=sc.nextInt();
		int n=sc.nextInt();
		
		int map[][]=new int[n][m];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		printMap(map);
//		dayGo(map);
//		printMap(map);
		
		
		if(!isOk(map)) {
			day=-1;
			
		}else {
			while(!isAll(map)) {
				
				dayGo(map);
				printMap(map);
				
			}
			
		}
		
		
		
		System.out.println(day);
		
		
	}

}
