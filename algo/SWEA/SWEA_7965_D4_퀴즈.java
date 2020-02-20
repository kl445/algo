package algo_ad.day2;

import java.util.Scanner;

public class SWEA_7965_D4_퀴즈 {

	public static void mult() {
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			double sum=0;
			int n=sc.nextInt();
			
			for (int j = 1; j <=n; j++) {
				double temp=Math.pow(j, j);
				sum+=temp%1000000007;
//				sum=(sum%1000000007);
			}
//			sum= (sum%1000000007);
			
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(i).append(" ").append(sum);
			System.out.println(sb.toString());
		} 
	}

}
