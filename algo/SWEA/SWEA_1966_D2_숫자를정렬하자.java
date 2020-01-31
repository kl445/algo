package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1966_D2_숫자를정렬하자 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int n= sc.nextInt();
			
			int array[] = new int[n];
			
			for(int j=0;j<n;j++) {
				array[j]=sc.nextInt();
			}
			
			Arrays.sort(array);
			
			System.out.print("#"+i);
			
			for(int value:array) {
				System.out.print(" "+value);
			}
			System.out.println();
		}

	}

}
