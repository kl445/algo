package algo.hw0522;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_3234_D4_준환이의양팔저울 {

	
	static int N;
	static int chu[];
	static int cnt;
	static int total=0;
	static int memo[]=new int[10];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(in.readLine());
		
		memo[0]=1;
		memo[1]=1;
		for (int tc = 1; tc <= TC; tc++) {
			
			N=Integer.parseInt(in.readLine());
			chu=new int[N];
			cnt=0;
			total=0;
			StringTokenizer tk=new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				chu[i]=Integer.parseInt(tk.nextToken());
				total+=chu[i];
			}
			
			dfs(0, 0,0, new boolean[N]);
			
			
			System.out.println("#"+tc+ " "+cnt);
		}
		
		
	}
	
	
	private static void dfs(int cur,int left, int right,boolean visited[]) {
		
		if(cur==N) {
			cnt++;
			return;
		}
		if(left>total/2) {
			int empt=(int) Math.pow(2, N-cur);
			
			cnt+=empt*fac(N-cur);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				
				visited[i]=true;
				if(left>=right+chu[i]) {
					right+=(chu[i]);
					dfs(cur+1, left,right, visited);
					right-=chu[i];
				}
				
				left+=(chu[i]);
				dfs(cur+1, left,right, visited);
				left-=chu[i];
				
				
				
				visited[i]=false;
				
			}
		}
	}
	private static int fac(int i) {
		if(memo[i]!=0) {
			return memo[i];
		}
		memo[i]=i*fac(i-1);
		return memo[i];
	}


}
