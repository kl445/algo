package com.object;

public class Testuser {

	
public static void main(String args[]) {
		
//		Test t= new Test();
//		
//		
//		Test t2= new Test();
//		
//		
//		//t를 사용
//		t.go();
//		System.out.println(t.num);
//		System.out.println(t.flag);
//		System.out.println(t.name);
//		System.out.println(t.d);
//		
//		t.stop();
//		
		System.out.println("**********");
		Car c= new Car();
		
		Car c3=new Car(5,"santafe","Mr.Lee");
		
		c.run();
		c.stop();
		
		
		c.info();
		
		c.num=2;
		c.model="sonata";
		c.owner="Mr.Park";
		
		c.info();
	
		
		c3.info();
		
	}
}
