package algo.hw0224;

import java.util.Scanner;

public class SWEA_8457_D3_알덴테스파게티 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {

			int n = sc.nextInt();

			int b = sc.nextInt();
			int e = sc.nextInt();

			int sand[] = new int[n];
			for (int j = 0; j < sand.length; j++) {
				sand[j] = sc.nextInt();
			}

			int cnt = 0;

			for (int k = 0; k < sand.length; k++) {
				for (int j = b - e; j <= b + e; j++) {
					if (j % sand[k] == 0) {
						cnt++;
						break;

					}
				}
			}

			System.out.printf("#%d %d\n", i, cnt);

		}
	}

}
