package algo.hw0201;

import java.util.Scanner;

public class SWEA_2005_D2_파스칼의삼각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<tc;i++) {
			int n= sc.nextInt();
			n++;
			int array[][]=new int[n][n];
			array[1][1]=1;
			
			for(int j=2; j<n;j++) {
				for (int k = 1; k <n; k++) {
					array[j][k]=array[j-1][k-1]+array[j-1][k];
				}
			}
			
			System.out.println("#"+i);
			
			for (int j = 1; j < array.length; j++) {
				for (int k = 1; k < array.length; k++) {
					if(array[j][k]!=0) {
						System.out.print(array[j][k]+" ");
					}
				}
				System.out.println();
			}
		
		}
	}
	

}
