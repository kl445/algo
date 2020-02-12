package swea_0212;

import java.util.Scanner;
import java.util.Stack;


public class SWEA_1961_D2숫자배열회전 {

	
	public static void printmap(int map[][]) {
		for (int j = 0; j < map.length; j++) {
			for (int j2 = 0; j2 < map[0].length; j2++) {
				System.out.print(map[j][j2]);
			}
			System.out.println();
		}
	}
	
	public static void w90(int[][] map, int newMap[][]) {
	
		Stack<Integer> st =new Stack<>();
		
		
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap.length; j++) {
				
				newMap[j][newMap.length-1-i]=map[i][j];
				
			}
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			int[][] map=new int[n][n];
			int[][] map2=new int[n][n];
			int[][] map3=new int[n][n];
			int[][] map4=new int[n][n];
			
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=sc.nextInt();
				}
			}
			
//			printmap(map);
			w90(map,map2);
//			printmap(map);
			w90(map2,map3);
//			printmap(map);
			w90(map3,map4);
			
			System.out.println("#"+i);
			for (int j = 0; j < map4.length; j++) {
				for (int k = 0; k < map4.length; k++) {
					System.out.print(map2[j][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < map4.length; k++) {
					System.out.print(map3[j][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < map4.length; k++) {
					System.out.print(map4[j][k]);
				}
				System.out.println();
			}
			
			
			
			
			
			
			
		}
	}

}
