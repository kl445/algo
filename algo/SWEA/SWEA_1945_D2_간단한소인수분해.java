package swea_0205;

import java.util.Scanner;

public class SWEA_1945_D2_간단한소인수분해 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int n=sc.nextInt();
				int temp=n;
				int a=0;
				while(temp%2==0) {
					temp/=2;
					a++;
				}
				int b=0;
				temp=n;
				while(temp%3==0) {
					temp/=3;
					b++;
				}
				int c=0;
				temp=n;
				while(temp%5==0) {
					temp/=5;
					c++;
				}
				int d=0;
				temp=n;
				while(temp%7==0) {
					temp/=7;
					d++;
				}
				int e=0;
				temp=n;
				while(temp%11==0) {
					temp/=11;
					e++;
				}
				
				
				System.out.printf("#%d %d %d %d %d %d\n",i,a,b,c,d,e);
		}
	}

}
