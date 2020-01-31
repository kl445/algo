package swea;

import java.util.Scanner;

public class SWEA_1209_D3_Sum {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		for(int i=1; i<=10;i++) {
			int tc=sc.nextInt();

			int[][] map= new int[100][100];
			int[] ans= new int[203];
			int max=0;
			
			for(int k=0;k<100;k++) {
				for(int j=0; j<100; j++) {
					map[k][j]=sc.nextInt();
				}
			}
			//가로
			for(int j=0;j<100;j++) {
				int sum=0;
				for(int k=0;k<100;k++) {
					sum +=map[j][k];
				}
				ans[j+1]=sum;
			}
			//세로
			
			for(int j=0;j<100;j++) {
				int sum=0;
				for(int k=0;k<100;k++) {
					sum +=map[k][j];
				}
				ans[j+101]=sum;
			}
			//오른대각
			for(int j=0;j<100;j++) {

				ans[201] +=map[j][j];
			}
			//왼대각
			for(int k=0,j=99;k<100;j--,k++) {

				ans[202] +=map[j][k];
			}
			
			for(int j=1;j<ans.length;j++) {
				max=Math.max(max, ans[j]);
			}
			System.out.printf("#%d %d\n",i,max);
						
		}
		

	}

}
