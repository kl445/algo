package com.ssafy.java;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {


		Random rand= new Random();
		
		int[] lotto = new int[6];
		
		for (int i = 0; i < lotto.length; i++) {
			
			lotto[i]=rand.nextInt(45)+1;
			
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
				
		}
		
		for(int value:lotto) {
			System.out.print(value+" ");
		}
		
		

	}

}
