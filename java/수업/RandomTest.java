package com.array;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {

	public static void main(String[] args) {
		//난수 발생 
		Random rand = new Random(); //random 객체 생성
//		
//		double i= 180+ rand.nextDouble(
//				);//0~9
//		
//		System.out.println(i);
//		

		//키보드로 인원수를 입력받아 배열생성하기
		//각각의 사람별 키를 배열에 입력하기(난수발생)
		//배열에 저장된 키중 제일 큰 값을 알아내 출력하기
		
		Scanner sc= new Scanner(System.in);
		
		int people=0;
		int[] peoples;
		int max=0;
		
		System.out.println("인원수 입력:");
		people=sc.nextInt();
		
		peoples= new int[people];
		
		for (int i = 0; i < peoples.length; i++) {
			peoples[i]=130+rand.nextInt(60);
			System.out.printf("%3d ",peoples[i]);
			if(max<peoples[i]) {
				max=peoples[i];
			}
		}
		System.out.printf("\n제일 큰 키는  %d 입니다.",max);
		
		
		
		
		
		

	}

}
