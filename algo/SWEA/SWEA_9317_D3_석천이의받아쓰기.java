package swea_0205;

import java.util.Scanner;

public class SWEA_9317_D3_석천이의받아쓰기 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			
			int n= sc.nextInt();
			String str=sc.next();
			String str2=sc.next();
			int cnt=0;
			
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)==str2.charAt(j)) {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n",i,cnt);
		}

	}

}
