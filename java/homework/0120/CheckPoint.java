package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cm;
		int kg;
		int res;

//		System.out.println("cm을 입력 해주세요");
		cm = sc.nextInt();

//		System.out.println("kg을 입력 해주세요");
		kg = sc.nextInt();
		
		res=kg+100-cm;
		
		System.out.println("비만수치는"+res+"입니다.");
		
		if(res>0) {
			System.out.println("당신은 비만이군요");
		}

	}

}
