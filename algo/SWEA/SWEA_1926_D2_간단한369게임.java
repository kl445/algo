package swea_0210;

import java.util.Scanner;

public class SWEA_1926_D2_간단한369게임 {

	
	public static int print(int i) {
		int cnt=0;
		
		if(i==0) {
//			cnt++;
//			System.out.print(i);
		}
		else if(i%3!=0) {
//			System.out.print(i);
//			cnt++;
		}
		else {
			cnt++;
//			System.out.print("-");
		}
		return cnt;
		
	}
	public static void main(String[] args) {


		Scanner sc =new Scanner(System.in);
		
		int n=sc.nextInt();
		
		
		for (int i = 1; i <=n; i++) {
			int cnt=0;
			int num=i;
			if(num>=1000) {
				cnt+=print(num/1000);
				num %=1000;
				cnt+=print(num/100);
				num %=100;
				cnt+=print(num/10);
				num %=10;
				cnt+=print(num);
			}
			else if(num>=100) {
				cnt+=print(num/100);
				num %=100;
				cnt+=print(num/10);
				num %=10;
				cnt+=print(num);
			}
			else if(num>=10) {
				cnt+=print(num/10);
				num %=10;
				cnt+=print(num);
			}
			else {
				cnt+=print(num);
			}
			
			if(cnt==0) {
				System.out.print(i);
			}else {
				for (int j = 0; j < cnt; j++) {
					System.out.print("-");
				}
			}
			System.out.print(" ");
		}

	}

}
