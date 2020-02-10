package swea_0210;

import java.util.Scanner;

public class SWEA_1970_D2_쉬운거스름돈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for (int i = 1; i <=tc; i++) {
		
			
			int num=sc.nextInt();
			
			int array[]=new int[8];
			while(true) {
			if(num>=50000) {
				array[0] +=num/50000;
				num %=50000;
			}
			else if(num>=10000) {
				array[1] +=num/10000;
				num %=10000;
			}
			else if(num>=5000) {
				array[2] +=num/5000;
				num %=5000;
			}
			else if(num>=1000) {
				array[3] +=num/1000;
				num %=1000;
			}
			else if(num>=500) {
				array[4] +=num/500;
				num %=500;
			}
			else if(num>=100) {
				array[5] +=num/100;
				num %=100;
			}
			else if(num>=50) {
				array[6] +=num/50;
				num %=50;
			}
			else if(num>=10) {
				array[7] +=num/10;
				num %=10;
			}else {
				break;
			}
			}
			
			
			System.out.println("#"+i);
			
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[j]+" ");
			}
			System.out.println();
			
		}
	}

}
