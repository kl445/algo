package algo.hw0402;

import java.math.BigInteger;
import java.util.Scanner;

public class SWEA5607_D3_조합 {

	static long[] memo = new long[1000001];
	static int p = 1234567891;

	  static long pow(long a, int b) {
	        
	        long start= 1;
	        long mult = a;
	        
	        while (b > 0) {
	            
	            if (b%2 == 1) start = start * mult  % p;
	            b = b/2;
	            mult = (mult * mult) % p;
	        }
	            
	        return start;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		memo[0]=1;
		for (int t = 0; t < tc; t++) {

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t + 1).append(" ");

			int N = sc.nextInt();
			int R = sc.nextInt();

			
			for (int i = 1; i <= N; i++) {
				memo[i]=(memo[i-1]*i)%p;
			}

			long ans = 0;
			
			long n_fac=memo[N];
			long nsubr_fac=memo[N-R];
			long r_fac=memo[R];
			
			long b=(nsubr_fac*r_fac)%p;
			ans=(n_fac*pow(b,p-2))%p;


			sb.append(ans);
			System.out.println(sb.toString());
		}
	}

}
