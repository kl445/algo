package com.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[] score= {100,23,56,78};
		String[] name= {"rolly","kim","Lee"};
		double[] point= {2.3,3.4,6.77};
		
		System.out.println(score.length);
//		for (int i = 0; i < score.length; i++) {
//			System.out.println(score[i]);
//		}
		
		for(int value:score) {
			System.out.println(value);
		}
		for(String value:name) {
			System.out.println(value);
		}
		for(double value:point) {
			System.out.println(value);
		}

	}

}
