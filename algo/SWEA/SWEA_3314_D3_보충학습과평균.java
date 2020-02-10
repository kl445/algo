package swea_0210;

import java.util.Scanner;

public class SWEA_3314_D3_보충학습과평균 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
for (int i = 1; i <= tc; i++) {
	

		int array[] = new int[5];
		int num = 0;
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			num = sc.nextInt();
			if (num < 40) {
				sum += 40;
			} else {
				sum += num;
			}

		}
		
		
		System.out.printf("#%d %d\n",i,sum/5);
	}}
}
