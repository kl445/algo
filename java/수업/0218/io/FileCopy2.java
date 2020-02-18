package com.exception;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] data= {10,20,30};
		
		for (int i = 0; i <= data.length; i++) {
			try {
			System.out.println(data[i]); //예외 발생 부분
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("잘못된 배열 접근");
				System.out.println(e.getMessage());
			}
			finally {
				System.out.println("finally......");
			}
		}
		
		System.out.println("done...");
	}

}
