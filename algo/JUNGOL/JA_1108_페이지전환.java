package algo.hw0416;

import java.util.Arrays;
import java.util.Scanner;

public class JA_1108_페이지전환 {

	static int N;
	static int[][] map;
	static final int MAX=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		
		for (int i = 0; i <map.length; i++) {
			Arrays.fill(map[i], MAX);
		}
		
		for (int i = 0; i < N; i++) {
			int r=sc.nextInt()-1;
			int c=sc.nextInt()-1;
			
			map[r][c]=1;
			
		}
		
		//경유지
		for (int k = 0; k < map.length; k++) {
			
			//출발지
			for (int i = 0; i < map.length; i++) {
				
				//출발지와 경유지가 같은 경우 생략
				if(i==k) continue;

				//도착지
				for (int j = 0; j < map.length; j++) {
					
					//도착지가 출발지 혹은 경유지와 같은 경우 생략
					if(i==j || k==j) continue;
					
					//경유지를 거쳐서 올 수 없는 경우 생략
					if(map[i][k]==MAX || map[k][j]==MAX) continue;
					
					//기존 경로와 새로운 경로를 비교
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
					
				}
			}
		}
		
		int big=0;
		int small=0;
		for (int i = 0; i < map	.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==MAX)  continue;
				
				big++;
				small+=map[i][j];
			}
		}
		double res=small/(double)big;
		System.out.printf("%.3f",Math.round(res*1000)/(double)1000);
		
		
		
	}

}
