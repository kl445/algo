package swea_0212;

import java.util.Scanner;

public class SWEA_1959_D2_두개의숫자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int n=sc.nextInt();
			
			int m=sc.nextInt();
			
			int[] num= new int[n];
			int[] mum= new int[m];
			
			
			for (int j = 0; j < num.length; j++) {
				num[j]=sc.nextInt();
				
			}
			for (int j = 0; j < mum.length; j++) {
				mum[j]=sc.nextInt();
			}
			
			
			int max=Integer.MIN_VALUE;
			
			if(n<m) {
				
				for (int j = 0; j <=(m-n); j++) {
					int temp=0;
					for (int k = 0; k < num.length; k++) {
						temp+=num[k]*mum[k+j];
					}
					max=Math.max(temp, max);
				}
				
			}
			else {
				for (int j = 0; j <=(n-m); j++) {
					int temp=0;
					for (int k = 0; k < mum.length; k++) {
						temp+=mum[k]*num[k+j];
					}
					max=Math.max(temp, max);
				}
			}
			
			System.out.printf("#%d %d\n",i,max);
			
		}
	}

}
