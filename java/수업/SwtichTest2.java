package com.basic;

public class SwtichTest2 {

	public static void main(String[] args) {
		
		int score = 90;
		switch (score) { //char short in byte long을 제외한 정수형, string(jdk 버전 8 이상)
			case 90:	
				System.out.println("lev-A");
				break;
			case 80:	
				System.out.println("lev-B");
				break;
			case 70:	
				System.out.println("lev-C");
				break;
			case 60:	
				System.out.println("lev-D");
				break;
	
			default:
				System.out.println("lev-F");
				break;
		}

	}

}
