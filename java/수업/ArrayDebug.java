package com.array;

public class ArrayDebug {

	public static void main(String[] args) {
		
		int[] score= {20,30,40,50,70,80,90,50,60};
		int sum=0;
		
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
			System.out.println(score[i]);
		}
		System.out.println(sum);
		
	}

}
