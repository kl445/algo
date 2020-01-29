package algo.hw;

import java.util.Scanner;

public class SWEA_8658_D3_Summation {

	public static int summation(int num) {
		
		if(num<10) {
			return num%10;
		}
		else {
			return summation(num/10)+num%10;
		}
		
		
	}
	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);

		int tc= sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int array[]=new int[10];
			for(int j=0; j<10;j++) {
				array[j]=sc.nextInt();
			}
			
			for(int j=0; j<10;j++) {
				array[j]=summation(array[j]);
			}
			int max=array[0];
			int min=array[0];
			for(int j=1; j<10;j++) {
				max=Math.max(max,array[j]);
				min=Math.min(min, array[j]);
			}
			System.out.printf("#%d %d %d\n",i,max,min);
			
			
			
		}
	}

}
