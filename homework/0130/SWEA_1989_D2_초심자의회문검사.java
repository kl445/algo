package algo.hw;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1989_D2_초심자의회문검사 {

	public static boolean palindrome(int start, int end, char[] array) {

		if (start == end) {
			return true;
		} else if (start + 1 == end) {
			return true;
		} else {
			return ((array[start] == array[end]) && palindrome(start + 1, end - 1, array));

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			String str = sc.next();
			char[] char_array = str.toCharArray();
			
			
			
			if (palindrome(0, char_array.length - 1, char_array)) {
				System.out.printf("#%d 1\n", i);
			} else {
				System.out.printf("#%d 0\n", i);
			}

		}

	}

}
