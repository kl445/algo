package algo.hw0201;

import java.util.Scanner;

public class SWEA5603_D3_건초더미 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int n=sc.nextInt();
			int array[]=new int[n];
			
			int sum=0;
			int avg=0;
			
			for (int j = 0; j < n; j++) {
				array[j]=sc.nextInt();
				sum+=array[j];
			}
			avg=sum/array.length;
			
			sum=0;
			for(int j=0; j<array.length;j++) {
				sum+=Math.abs(avg-array[j]);
			}
			
			System.out.printf("#%d %d\n",i,sum/2);
			
		}
	}

}
