package swea_0218;

import java.util.Scanner;

public class SWEA_1244_D3_최대상금 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {

			char[] c_array = sc.next().toCharArray();
			int n = sc.nextInt();

			max = -1;
			perm(0, 0, c_array, new char[c_array.length], n,0);

			System.out.printf("#%d %d\n", i, max);
		}
	}

	public static int getInt(char[] temp) {

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < temp.length; i++) {
			str.append(temp[i]);
		}

		int num = Integer.parseInt(str.toString());

		return num;
	}

	static int max = Integer.MIN_VALUE;

	public static void perm(int start, int c, char[] c_array, char[] temp, int n, int cnt) {

		if (n == c) {

			//if (isOk(c_array, temp, n)) {
				int ans = getInt(c_array);
				if (max < ans) {
					max = ans;
			//	}

			}
			return;
		} else {

			for (int i = start; i < c_array.length; i++) {
				for (int j = i + 1; j < c_array.length; j++) {
					if (c_array[i] <= c_array[j]) {
						char tem = c_array[i];
						c_array[i] = c_array[j];
						c_array[j] = tem;
						
						perm(i, c+1, c_array, temp, n, cnt);
						
						tem = c_array[j];
						c_array[j] = c_array[i];
						c_array[i] = tem;
					}

				}

			}
		}

	}

	public static boolean isOk(char[] c_array, char[] temp, int n) {

		int diff = 0;

		for (int i = 0; i < temp.length; i++) {
			if (c_array[i] != temp[i]) {
				diff++;
			}
		}

		if (diff / 2 <= n) {
			return true;
		}
		return false;
	}

}
