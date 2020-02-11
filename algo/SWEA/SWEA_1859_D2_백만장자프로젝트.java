package swea_0211;

import java.util.Scanner;

public class SWEA_1859_D2_백만장자프로젝트 {

	
	public static long max(int[] arr,int idx) {
		
		long max=Integer.MIN_VALUE;
		long sum=0;
		
		for (int i = idx; i < arr.length; i++) {
			max=Math.max(arr[i], max);
		}
		
		for (int i = idx; i < arr.length; i++) {
			if(arr[i]<max) {
				
				sum+=max-arr[i];
			}
			else {
				sum+=max(arr,i+1);
				break;
			}
		}
		
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		for (int i = 1; i <=tc; i++) {
			
			int n=sc.nextInt();
			
			int arr[]=new int[n];
			
			for (int j = 0; j < arr.length; j++) {
				arr[j]=sc.nextInt();
			}
			
			
			long sum=max(arr, 0);
			
			System.out.printf("#%d %d\n",i,sum);
			
			
		}
	}

}
