package com.exception;

class Car{
	int num;
	
	public Car(int num) {
		this.num=num;
	}
	
	
}

public class ExceptionTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car c= null;
		int result =0;
		
		int a=3, b=0;
		
		try {
			result= a/b;
			System.out.println(c.num);
			
		}catch(ArithmeticException e) {
			result=999;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
//		try {
//			result= a/b;
//			System.out.println(c.num);
//			
//		}catch(ArithmeticException e) {
//			System.out.println("익셉션");
//			System.out.println(e);
//			result=999;
//		}catch(NullPointerException n) {
//			System.out.println(n);
//			System.out.println("익셉션");
//			c =new Car(5);
//		}
		
//		System.out.println(c.num);
		System.out.println(result);
		
		
	}

}
