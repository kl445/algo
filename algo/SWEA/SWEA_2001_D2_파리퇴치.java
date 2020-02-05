package algo.hw0201;

import java.util.Scanner;

public class SWEA_2001_D2_파리퇴치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			
			int n= sc.nextInt();
			int m= sc.nextInt();
			int map[][]=new int[n][n];
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			int max=0;
			for (int a = 0; a < map.length-m+1; a++) {
				for (int b = 0; b < map.length-m+1; b++) {
					//파리채
					int sum=0;
					for (int c = a; c < a+m; c++) {
						for (int d = b; d < b+m; d++) {
							sum+=map[c][d];
						}
					}
					max=Math.max(max, sum);
				}
			}
			
			System.out.printf("#%d %d\n",i,max);
			
			
		}

	}

}
