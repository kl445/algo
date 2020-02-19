package algo_ad.day1;

import java.util.Scanner;

public class SWEA_1244_D3_최대상금 {

	static int max = Integer.MIN_VALUE;

	public static int getSum(char[] array) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < array.length; i++) {
			str.append(array[i]);
		}

		int num = Integer.parseInt(str.toString());

		return num;
	}

	public static void swap(char[] array, int idx1, int idx2) {
		char temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}

	public static void perm(int n, int c, char[] array,int start) {

		if (n == c) {
			
			
			max = Math.max(max, getSum(array));

		} else {
			for (int i = start; i < array.length; i++) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[j] >= array[i]) {
						swap(array, i, j);
						perm(n, c + 1, array,i);
						swap(array, i, j);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			String str = sc.next();

			max = Integer.MIN_VALUE;

			char[] array = str.toCharArray();
			int n = sc.nextInt();
			perm(n, 0, array,0);
			System.out.printf("#%d %d\n",i,max);
		}

	}

}
