package com.java.first;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int num1;
		int num2;
		
//		System.out.println("num1을 입력 해주세요");
		num1= sc.nextInt();
		
//		System.out.println("num2을 입력 해주세요");
		num2= sc.nextInt();
		
		System.out.println("곱= "+(num1*num2));
		System.out.println("몫= "+(num1/num2));
		
		
	}

}
