package algo.hw0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * dp로 풀기 
 * 3차원 map 사용 [파이프 형태][r][c]
 * 
 *
 */

public class BOJ_17070_파이프옮기기1 {

	static int N;
	static int map[][];
	static int memo[][][];
	static int max;
	

	public static void main(String[] args) throws  IOException {
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(input.readLine());
		
		map=new int[N+1][N+1];
		memo=new int[3][N+1][N+1];
		memo[0][1][2]=1;
		StringTokenizer tk=null;
		for (int i = 1; i <= N; i++) {
			tk=new StringTokenizer(input.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j]=Integer.parseInt(tk.nextToken());

			}
			
		}
		

		
		
		
		max+=dfs(0, N, N);

		max+=dfs(1, N, N);

		max+=dfs(2, N, N);

		System.out.println(max);

	}
	
	static void print() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < N+1; j++) {
				System.out.println(Arrays.toString(memo[i][j]));
			}
			System.out.println("****************");
		}
		System.out.println("@@@@@@@@@@@@@@@@@@");
	}

	private static int dfs(int type, int r, int c) {
		
		if(r==0 || c==0) {
			return 0;
		}
		

		if(memo[type][r][c]!=0) {
			return memo[type][r][c];
		}
		
		if(type==1) {
			if(map[r][c]==0 && map[r-1][c]==0 && map[r][c-1]==0) {
				memo[type][r][c]=dfs(0,r-1,c-1)+dfs(1,r-1,c-1)+dfs(2,r-1,c-1);
				return memo[type][r][c];
			}
		}
		else {
			if(map[r][c]==0) {
				if(type==0) {
					memo[type][r][c]=dfs(0,r,c-1)+dfs(1,r,c-1);
					return memo[type][r][c];
				}
				else {
					memo[type][r][c]=dfs(1,r-1,c)+dfs(2,r-1,c);
					return memo[type][r][c];
				}
			}
		}
		
		return memo[type][r][c];
		
	}
	

}
