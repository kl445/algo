package swea_0211;

import java.util.Scanner;

public class SWEA_1984_D2_중간평균값구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i =1; i <=tc; i++) {
			
			int[] arr=new int[10];
			
			int max=Integer.MIN_VALUE;
			int max_idx=0;
			int min=Integer.MAX_VALUE;
			int min_idx=0;
			
			for (int j = 0; j < arr.length; j++) {
				arr[j]=sc.nextInt();
				if(max<arr[j]) {
					max=arr[j];
					max_idx=j;
				}
				
				if(min>arr[j]) {
					min=arr[j];
					min_idx=j;
				}
			}
			arr[max_idx]=0;
			arr[min_idx]=0;
			
			double sum=0;
			for (int j = 0; j < arr.length; j++) {
				
				sum+=arr[j]	;
			}
			
			System.out.printf("#%d %.0f\n",i,sum/8);
			
			
			
		}
	}

}
