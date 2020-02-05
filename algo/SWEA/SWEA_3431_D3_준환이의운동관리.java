package swea_0205;

import java.util.Scanner;

public class SWEA_3431_D3_준환이의운동관리 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		int tc= sc.nextInt();
		
		for (int i = 1; i <=tc; i++) {
			int l= sc.nextInt();
			int u= sc.nextInt();
			int x= sc.nextInt();
			int ans=0;
			
			if(x>u) {
				ans=-1;
			}
			else if(x<=u && x>=l) {
				ans=0;
			}
			else {
				ans=l-x;
			}
			
			System.out.printf("#%d %d\n",i,ans);
		}

	}

}
