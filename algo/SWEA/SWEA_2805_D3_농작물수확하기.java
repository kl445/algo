package swea;

import java.util.Scanner;

public class SWEA_2805_D3_농작물수확하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc;i++) {
			int n=sc.nextInt();
			int map[][]= new int[n][n];
			
			
			for(int j=0;j<n;j++) {
				String str=sc.next();
				for(int k=0; k<n;k++) {
					map[j][k]=str.charAt(k)-'0';
					
				}
			}
//			for(int j=0;j<n;j++) {
//				for(int k=0; k<n;k++) {
//					System.out.print(map[j][k]+" ");
//				}
//				System.out.println();
//			}
			
			
			
			int sum=0;
			
			int start=0;
			int end=n;
			for(int j=n/2; j>=0;j--) {
				
				
				for(int k=start;k<end;k++) {
					sum +=map[j][k];
				}
				start++;
				end--;
			}
			 start=1;
			 end=n-1;
			for(int j=(n/2)+1; j<n;j++) {
			
				
				for(int k=start;k<end;k++) {
					sum +=map[j][k];
				}
				start++;
				end--;
			}
			
			System.out.printf("#%d %d\n",i,sum);
			
			
			
			
		}
	}

}
