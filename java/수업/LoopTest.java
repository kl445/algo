package com.basic;

public class LoopTest {

	public static void main(String[] args) {

		/*
		 * for (int i = 0; i < 5; i++) { System.out.println(i+"hello"); }
		 * System.out.println("\n");
		 * 
		 * for (int i = 5; i > 0; i--) { System.out.println(i+ "bye");
		 * 
		 * }
		 */

		here: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1)
					break here;
				System.out.print(i + "," + j + " ");
			}
			System.out.println();
		}

		/*
		 * int i=0; while(i<5) { System.out.println("*"); i++; }
		 */
		int k = 99;
		do {
			System.out.println("hello");
			k++;
		} while (k > 200);

	}

}
