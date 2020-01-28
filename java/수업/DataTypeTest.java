package com.basic;

public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HelloWorld some;
		
		boolean flog= false;
		byte b= 120;
		b= (byte)(b+1); //(원하는타입):형변환 연산자 
		int b2= b+1;
		short a =3800;
		a=(short)(a+1);
		int i= 12345;
		char c = 98;
		c= 'A'+1;
		String name= "tommy";
		
//		float f = 3.14f;
		float f =(float)3.14;
		
		double d = 6.98;
		
		
		System.out.println(flog);
		System.out.printf("셋 %f",f);
		System.out.println(a);
		System.out.println(c);
		System.out.println(i);
		System.out.println(f);
		System.out.println(d);
		System.out.println(name);
		System.out.println(b2);
		
	}

}
