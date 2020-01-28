package com.array;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		
		int num1,num2,res;
		num1=Integer.parseInt(args[0]);
		num2=Integer.parseInt(args[1]);
		res=num1+num2;
		System.out.println(res);
		
		
		for(String value:args) {
			System.out.println(value);
		}
	}

}
