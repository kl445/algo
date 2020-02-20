package algo_ad.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {

	private static int cnt=0;
	
	public static void pipe(int map[][],int r, int c){
	
		int start=map[r][c];
		
		switch (start) {
		case 2:
			
			break;

		case 3:
		default:
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(tk.nextToken());
		
		int map[][]=new int[n][n];
		
		for (int i = 0; i < map.length; i++) {
			tk=new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j]=Integer.parseInt(tk.nextToken());
			}
		}
		
		map[0][0]=2;
		map[0][1]=2;
		
		

	}

}
