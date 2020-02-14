package swea_0213;

import java.util.Scanner;

//public class Solution {
public class SWEA_1861_D4_정사각형방 {

	private static int[][] dirs= {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static boolean isIn(int r, int c, int n) {
		return(r>-1 && c>-1 && r<n && c<n);
		
	}
	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map.length; k++) {
				System.out.printf("%2d ",map[i][k]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			int map[][]=new int[n][n];
			int min=Integer.MAX_VALUE;
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k]=sc.nextInt();
					min=Math.min(map[j][k],min);

				}
			} 
			
//			printMap(map);
			
			int start_room=Integer.MAX_VALUE;
			int range=1;
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					
					if(map[j][k]>0) {
						
						int r=j;
						int c=k;
						int now_room=map[j][k];
						int now_range=1;
						boolean flag=true;
						while(flag) {
							
							
							for (int d = 0; d < dirs.length; d++) {
								int nr=r+dirs[d][0];
								int nc=c+dirs[d][1];
								
								if(isIn(nr, nc, n) && map[nr][nc]==map[r][c]+1) {
									
									boolean flag2=true;
									for (int d2 = 0; d2 < dirs.length; d2++) {
										int nr2=r+dirs[d2][0];
										int nc2=c+dirs[d2][1];
										if(isIn(nr2, nc2, n) && map[nr2][nc2]==map[r][c]-1) {
											flag2=false;
											
										}
									}
									
									if(flag2) {
										map[r][c]=0;
									}
//										map[nr][nc]=0;
										r=nr;
										c=nc;
										now_range++;
										flag=true;
										break;
									
								}
								else {
									flag=false;
								}
		
							}
							
//							printMap(map);
						}
						
						if(now_range>range) {
							range=now_range;
							start_room=now_room;
						}
						else if(now_range==range) {
							range=now_range;
							start_room=Math.min(start_room,now_room);
						}
						
					}
				}
			}
			
			if(start_room==Integer.MAX_VALUE) {
				start_room=min;
			}
			System.out.printf("#%d %d %d\n",i,start_room,range);
			
			
			
			
			
		}
	}

}
