package algo_ad.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {

	private static int Color[]= {0,0};
	
	
	public static boolean isOne(int[][] map,int r,int c, int n) {
		int start=map[r][c];
		
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(map[i][j]!=start ) {
					return false;
				}
			}
		}
		Color[start]++;
		return true;
				
	}

	
	public static void makeColor(int[][] map, int r, int c, int n) {
		
		if(!isOne(map, r, c, n)) {
			makeColor(map, r, c, n/2);
			makeColor(map, r, c+n/2, n/2);
			makeColor(map, r+n/2, c, n/2);
			makeColor(map, r+n/2, c+n/2, n/2);
		}
		
	}
	public static void main(String[] args) throws Exception {
		
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer tk=new StringTokenizer(bf.readLine());
			
			int n=Integer.parseInt(tk.nextToken());
			
			int map[][]=new int[n][n];
			
			for (int i = 0; i < map.length; i++) {
				tk=new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j]=Integer.parseInt(tk.nextToken());
				}
			}
			
			
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			makeColor(map, 0, 0, n);
			
			System.out.println(Color[0]);
			System.out.println(Color[1]);

	}

}
