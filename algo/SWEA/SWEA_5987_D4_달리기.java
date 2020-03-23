package algo.hw0319;

import java.util.Scanner;

public class SWEA_5987_D4_달리기 {

	static int T;
	static int N, M;
	static int count;
	static int[] needs;
	static long[] memo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			
			N=sc.nextInt();
			M=sc.nextInt();
			needs=new int[N];
			memo=new long[(1<<N)];
			
			int f,s;
			for (int i = 0; i < M; i++) {
				f=sc.nextInt()-1;
				s=sc.nextInt()-1;
				needs[f] |=(1<<s);
				
			}
			
			count=0;
			
			long r=dfs(0);
			
			System.out.println("#"+t+" "+r);
			
		}
	}

	private static long dfs(int flag) {

		if(flag==(1<<N)-1) {
			//count++;
			return 1;
		}
		if(memo[flag]>0) {
			return memo[flag];
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1<<i)==0) {
				if((flag &needs[i])==needs[i]) {
					memo[flag]+=dfs(flag | 1<<i);
				}
				
			}
		}
		return memo[flag];
	}

}
