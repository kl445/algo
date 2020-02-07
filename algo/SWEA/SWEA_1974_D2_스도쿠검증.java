package algo.hw;

import java.util.Scanner;

public class SWEA_1974_D2_스도쿠검증 {

	public static int rowOk(int[][] map,int a,int b, int max_a, int max_b) {
		
		int sum=0;
		for (int j = a; j <max_a; j++) {
			for (int k = b; k < max_b; k++) {
				sum+=map[j][k];
				
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1;	 i <=tc; i++) {
			
			int[][] map= new int[9][9];
			
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					map[j][k]=sc.nextInt();
				}
			}
			
//			for (int j = 0; j < map.length; j++) {
//				for (int k = 0; k < map.length; k++) {
//					System.out.print(map[j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println("******");
			
			int cnt=0;
			int sum=0;
			int le=0;
			for (int j = 0; j < map.length; j++) {
				sum=0;
				for (int k = 0; k < map.length; k++) {
					sum+=map[j][k];
					
				}
				if(sum==45) {
					cnt++;
				}
//				System.out.println(sum+":"+(le++));
			}
			
			sum=0;
			for (int j = 0; j < map.length; j++) {
				sum=0;
				for (int k = 0; k < map.length; k++) {
					sum+=map[k][j];
					
				}
				if(sum==45) {
					cnt++;
				}
//				System.out.println(sum+":"+(le++));
			}
//			System.out.println(sum+":"+(le++));
			//1
			sum=rowOk(map,0,0,3,3);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//2
			sum=rowOk(map,0,3,3,6);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//3
			sum=rowOk(map,0,6,3,9);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//4
			sum=rowOk(map,3,0,6,3);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//5
			sum=rowOk(map,3,3,6,6);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//6
			sum=rowOk(map,3,6,6,9);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//7
			sum=rowOk(map,6,0,9,3);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//8
			sum=rowOk(map,6,3,9,6);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			//9
			sum=rowOk(map,6,6,9,9);
			if(sum==45) {
				cnt++;
			}
//			System.out.println(sum+":"+(le++));
			int ans=0;
//			System.out.println(cnt);
			if(cnt==27) {
				ans=1;
			}
				
			
			
			System.out.printf("#%d %d\n",i,ans);
			
		}
	}

}
