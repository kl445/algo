package swea_0211;

import java.util.Scanner;

public class SWEA_1976_D2_시각덧셈 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			int h=sc.nextInt();
			int m=sc.nextInt();
			
			h+=sc.nextInt();
//			h=h%12+1;
			
			m+=sc.nextInt();
			
			if(m>=60) {
				h++;
				m=m%60;
			}
			
			if(h>12) {
				
				h=h%12;
				if(h==0) {
					h=12;
				}
			}
			System.out.printf("#%d %d %d\n",i,h,m);
		}

	}

}
