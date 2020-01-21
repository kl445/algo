package com.ssafy.java;

public class ArrayTest {
	
	public static void main(String[] args) {

		
		int[] array={34,23,64,25,12,75,22,88,53,37};
		int sum=0;
		int avg=0;
		int min=array[0];
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%2d ",array[i]);
			sum+=array[i];
			if(min>array[i])
				min=array[i];
		}
		avg=sum/array.length;
		System.out.println();
		System.out.println("배열의 합: "+sum);
		System.out.println("배열의 평균: "+avg);
		System.out.println("배열의 최소값: "+min);
		
		

	}

}
