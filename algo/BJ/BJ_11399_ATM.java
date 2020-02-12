package swea_0212;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11399_ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		
		Arrays.sort(arr);
		
		int sum[]=new int[n+1];
		for (int i = 0; i < arr.length; i++) {
			sum[i+1]=sum[i]+arr[i];
		}
		int res=0;
		
		for (int i = 1; i < sum.length; i++) {
			res+=sum[i];
		}
		System.out.println(res);
	}

}
