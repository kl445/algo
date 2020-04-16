package algo.hw0416;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {

	static int memo[];


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();

		memo = new int[1000001];

		memo[1] = 0;

		int cnt = 0;

		for (int i = 2; i <= M; i++) {
			
			memo[i]=memo[i-1]+1;
			
			if(i%3==0) {
				memo[i]=Math.min(memo[i], memo[i/3]+1);
			}
			if(i%2==0) {
				memo[i]=Math.min(memo[i], memo[i/2]+1);
			}

		}
		System.out.println(memo[M]);

	}

}
