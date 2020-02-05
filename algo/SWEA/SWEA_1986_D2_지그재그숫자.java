package swea_0205;

import java.util.Scanner;

public class SWEA_1986_D2_지그재그숫자 {

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int sum=0;
			
			int flag=1;
			int n=sc.nextInt();
			
			for(int j=1; j<=n;j++ ) {
				sum +=j*flag;
				flag*=-1;
			}
			
			System.out.printf("#%d %d\n",i, sum);
		}

	}

}
