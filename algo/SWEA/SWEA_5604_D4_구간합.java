package algo.hw0318;

import java.util.Scanner;

public class SWEA_5604_D4_구간합 {

	static long a, b;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			a = sc.nextLong();
			b = sc.nextLong();

			long[] ans = new long[10];
			long point = 1;
			while (a <= b) {
				while (b % 10 != 9 && a <= b) {
					cal(b, ans, point);
					b--;

				}
				if (b < a) {
					break;
				}
				while (a % 10 != 0 && a <= b) {
					cal(a, ans, point);
					a++;
				}
				a /= 10;
				b /= 10;
				for (int i = 0; i < 10; i++) {
					ans[i] += (b - a + 1) * point;
				}
				point *= 10;
			}
			long sum = 0;
			for (int i = 0; i < ans.length; i++) {
				sum += (ans[i] * i);
			}

			System.out.printf("#%d %d\n", t, sum);
		}
	}

	private static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length() - 1) - '0';
			ans[xx] += point;
			x /= 10;
		}

	}

}
