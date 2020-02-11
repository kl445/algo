package swea_0211;

import java.util.Scanner;

public class SWEA_1979_D2_어디에단어가들어갈수있을까 {

//	public static int set(int[][] map) {
//		
//		int cnt=0;
//	
////		print(map);
//		for (int j = 0; j < map.length; j++) {
//			int range=0;
//			
//			for (int k = 0; k < map.length; k++) {
//				if(map[j][k]==1) {
//					int temp_k=k;
//					
//					while(true) {
//						if(temp_k==map.length || map[j][temp_k]==0) {
//							
//							break;
//						}
//						map[j][temp_k]=0;
//						range++;
//						temp_k++;
//					}
//					if(range==kay) {
//						cnt++;
//					}
//					range=0;
////					print(map);
//				}
//			}
//		}
//		return cnt;
//		
//	}
	
	public static void print(int[][] map) {
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			int kay=sc.nextInt();
			
			
			int[][] realmap=new int[n][n];
			int[][] map=new int[n][n];
			
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					realmap[j][j2]=sc.nextInt();
					map[j][j2]=realmap[j][j2];
				}
			}
//			print(realmap);
			
			int cnt=0;
			
			
//			print(map);
			for (int j = 0; j < map.length; j++) {
				int range=0;
				
				for (int k = 0; k < map.length; k++) {
					if(map[j][k]==1) {
						int temp_k=k;
						
						while(true) {
							if(temp_k==map.length || map[j][temp_k]==0) {
								
								break;
							}
							map[j][temp_k]=0;
							range++;
							temp_k++;
						}
						if(range==kay) {
							cnt++;
						}
						range=0;
//						print(map);
					}
				}
			}
			
			
//			print(realmap);
			for (int j = 0; j < realmap.length; j++) {
				int range=0;
				
				for (int k = 0; k < realmap.length; k++) {
					if(realmap[k][j]==1) {
						int temp_k=k;
						
						while(true) {
							if(temp_k==realmap.length || realmap[temp_k][j]==0) {
								break;
							}
							realmap[temp_k][j]=0;
							range++;
							temp_k++;
						}
						if(range==kay) {
							cnt++;
						}
						range=0;
//						print(realmap);
					}
				}
			}
			
			
		System.out.printf("#%d %d\n",i,cnt);	
		}
	}

}
