package com.ssafy.java;

public class AlpaTest2 {

	public static void main(String[] args) {
		
		
		char alpa = 'A';

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if((4-i)<=j)
					System.out.print((alpa++) + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

	}

}
