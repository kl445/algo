package algo.hw0416;

import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static int N;
	static int record[];
	static int memo[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		record=new int[N];
		memo=new int[N];
		
		for (int i = 0; i < N; i++) {
			record[i]=sc.nextInt();
		}
		if(N==1) {
			System.out.println(record[0]);
		}
		else if(N==2) {
			System.out.println(record[0]+record[1]);
		}else {
			
		
		memo[0]=record[0];
		memo[1]=record[0]+record[1];
		memo[2]=Math.max(memo[0]+record[2], record[1]+record[2]);
		
		for (int i = 3; i < N; i++) {
			
			memo[i]=Math.max(memo[i-2]+record[i], memo[i-3]+record[i-1]+record[i]);
		}
		
		System.out.println(memo[N-1]);
		}
		
		
		
	}

}
