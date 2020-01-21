package com.ssafy.algo;
import java.util.*;

public class DigitTest1 {

	public static void main(String[] args) {

		
		Scanner sc= new Scanner(System.in);
		
		int[] digitarray =new int[10];
		
		int num=-1;
		
		
		while(true) {
			
			num=sc.nextInt();
		
			if (num==0)
				break;
			
			digitarray[num/10]++;
		}
		
		for (int i = 0; i < digitarray.length; i++) {
			if(digitarray[i]!=0)
				System.out.printf("%d: %d개 \n",i,digitarray[i]);
		}
		
		
		
		
	}

}
