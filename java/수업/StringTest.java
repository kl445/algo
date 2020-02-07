package com.day0207;



public class StringTest {

	public static void main(String[] args) {
		
		System.out.println(StaticTest.scount);
		
		StaticTest.go();
		// TODO Auto-generated method stub

		String s="mylimorange";
		String t= new String("mylimorange"	);
		String x="mylimorange";
		
		System.out.println(s==t);
		System.out.println(s==x);
		System.out.println(s.equals(t));
		
		String k=s.toUpperCase();
		System.out.println(s);
		System.out.println(k);
	
		k=s.concat("gogo");
		System.out.println(s);
		System.out.println(k);
		
		s=s+"hi";
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(s.substring(2,6));
		System.out.println(s.substring(5));
	}

}
