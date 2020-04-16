package algo.hw0416;

import java.util.Scanner;

public class BOJ_11726_2xn타일링 {

	static int[] memo;
	static int p=10007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		
		memo=new int[1001];
		
		memo[1]=1;
		memo[2]=2;
		
		
		for (int i = 1; i <= t; i++) {
			if(i>2) {
				memo[i]=(memo[i-1]%p+memo[i-2]%p)%p;
			}
		}
		
		System.out.println(memo[t]);
		
	}

}
