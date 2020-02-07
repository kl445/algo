package swea_0207;

import java.util.Scanner;

public class SWEA_5549_D4_홀수일까짝수일까 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			String str=sc.next();
			int n=str.charAt(str.length()-1)-'0';
	
			if(n%2==0) {
				System.out.println("#"+i+" Even");
			}
			else {
				System.out.println("#"+i+" Odd");
			}
		}
	}

}
