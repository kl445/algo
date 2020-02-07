package com.day0207;

public class StaticTest {

	static int scount;
	int count;
	
	static void go() {
		System.err.println("gogogogo~~~");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(scount);
		System.out.println(scount);
		go();
		System.out.println(scount);
		System.out.println(scount);
		//super, this는 static에서 못씀
			
		
//		StaticTest s1=new StaticTest();
//		StaticTest s2=new StaticTest();
//		StaticTest s3=new StaticTest();
//
//		System.out.println(++s1.count+"--"+ ++s2.count+"--"+ ++s3.count);
//		System.out.println(++s1.scount+"--"+ ++s2.scount+"--"+ ++s3.scount);
	}

}
