package swea_0207;

import java.util.Scanner;

public class SWEA_8821_D3_적고지우기 {

	public static void main(String[] args) {


		Scanner sc= new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			
			String str= sc.next();
			
			int[] count= new int[10];
			
			for (int j = 0; j < str.length(); j++) {
				count[str.charAt(j)-'0']++;
			}
			
			int cnt=0;
			for (int j = 0; j < count.length; j++) {
				if(count[j]%2==1) {
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n",i,cnt);
			
			
		}

	}

}
