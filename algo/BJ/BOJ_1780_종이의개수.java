package algo_ad.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	private static int[] res=new int[3];
	
	public static boolean isAll(int map[][], int r, int c, int n) {
		
		int start=map[r][c];
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(map[i][j]!=start) {
					return false;
				}
			}
		}
		
		res[start]++;
		return true;
	}
	
	
	public static void paper(int map[][], int r, int c, int n) {
		
		if(!isAll(map, r, c, n)) {
			
			paper(map, r, c, n/3);
			paper(map, r, c+(n/3), n/3);
			paper(map, r, c+(2*n/3), n/3);
			paper(map, r+(n/3), c, n/3);
			paper(map, r+(n/3), c+(n/3), n/3);
			paper(map, r+(n/3), c+(2*n/3), n/3);
			paper(map, r+(2*n/3), c, n/3);
			paper(map, r+(2*n/3), c+(n/3), n/3);
			paper(map, r+(2*n/3), c+(2*n/3), n/3);
			
			
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk= new StringTokenizer(br.readLine());

		int n=Integer.parseInt(tk.nextToken());
		
		int map[][]=new int[n][n];
		
		
		for (int i = 0; i < map.length; i++) {
			tk=new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j]=1+Integer.parseInt(tk.nextToken());
			}
		}
		
		paper(map, 0, 0, n);
		
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
		
	}

}
