package swea_0212;

import java.util.Scanner;

public class JO_1523_별삼각형1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int tc = sc.nextInt();

		
		switch (tc) {

		case 1:

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j <= i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}

			break;

		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {

					System.out.print("*");

				}
				System.out.println();
			}
			break;

		case 3:
			int n2=n+n-1;
			
			int start=n;
			int end=start+2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n2; j++) {
					
					if (j > start&& j<end) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					
				}
				start--;
				end++;
				System.out.println();
			}
			break;

		}

	}

}
