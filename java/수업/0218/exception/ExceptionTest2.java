package com.exception;

public class ExceptionTest2 {

	public void first(int num) throws Exception {
		second(num);
	}
	public void second(int num) throws Exception {
		third(num);
	}
	public void third(int num) throws Exception {
		if(num>0) {
			System.out.println(++num);
		}
		else {
//			Exception e= new Exception();
//			throw e;
			
			throw new  Exception();
		}
	}

	public static void main(String[] args) throws Exception {

		new ExceptionTest2().first(-9);
//		try {
//			new ExceptionTest2().first(-1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println("양수르 잉ㅂ력");
//		}
	}

}
