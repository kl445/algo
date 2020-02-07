package swea_0207;

import java.util.Scanner;

public class SWEA_5162_D3_두가지빵의딜레마 {

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);	
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int bre1=sc.nextInt();
			int bre2= sc.nextInt();
			
			int money=sc.nextInt();
			
			
			int set=Math.min(bre1, bre2);
			
			set=money/set;
			
			System.out.printf("#%d %d\n",i,set);
		}
	}

}
