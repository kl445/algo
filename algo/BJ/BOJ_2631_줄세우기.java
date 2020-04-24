package algo.hw0423;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2631_줄세우기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[] array=new int[n];
		int[] lis=new int[n];
		
		
		for (int i = 0; i < n; i++) {
			array[i]=sc.nextInt();
			lis[i]=1;
		}
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if(array[i]>array[j] && lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
				}
				
			}
		}
//		System.out.println(Arrays.toString(lis));
		
		int maxidx=0;
		int max=0;
		for (int i = 0; i < lis.length; i++) {
			if(max<lis[i]) {
				maxidx=i;
				max=lis[i];
			}
		}
		System.out.println(n-lis[maxidx]);
	}

}
