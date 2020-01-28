package com.basic;

public class SwtichTest {

	public static void main(String[] args) {
		
		char code= 'A';
		
		switch (code) {
			case 'A':
			case 'a':
				System.out.println(" a search");
				break;
			case 'b':
				System.out.println(" b search");
				break;
			case 'c':
				System.out.println(" c search");
				break;
			case 'd':
				System.out.println(" d search");
				break;
	
			default:
				break;
		}
	}

}
