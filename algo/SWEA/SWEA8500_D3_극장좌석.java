package algo.hw0224;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA8500_D3_극장좌석 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <= tc; i++) {
			int n=sc.nextInt();
		
			int array[]=new int[n];
		
			
			for (int j = 0; j < array.length; j++) {
				array[j]=sc.nextInt();
			
			}
			Arrays.sort(array);
			
			int range=0;
			
//			range+=array[0];
			for (int j = 0; j < array.length; j++) {
				
				range+=array[j];
				
			}
			range+=array[array.length-1];
			range+=n;
			System.out.printf("#%d %d\n",i,range);
		}
		
		
	}

}
