package swea;

import java.util.Scanner;

public class SWEA_1948_D2_날짜계산기 {

	private static int[] month = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			int[] f_day = new int[2];
			int[] l_day = new int[2];

			f_day[0] = sc.nextInt();
			f_day[1] = sc.nextInt();
			l_day[0] = sc.nextInt();
			l_day[1] = sc.nextInt();

			int day = 0;

			if (f_day[0] == l_day[0]) {
				day += l_day[1]-f_day[1]+1;

			} else {
				day += l_day[1];
				day += month[f_day[0]] + 1 - f_day[1];

				for (int j = f_day[0]+1; j < l_day[0]; j++) {
//					System.out.println("f:" + f_day[0] + " l:" + l_day[0] + " j" + j);
					day += month[j];
				}
			}
			System.out.printf("#%d %d\n", i, day);

		}

	}

}
