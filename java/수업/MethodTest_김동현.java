package com.method;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MethodTest {

//	hello()L:화면에 hllo 출력
	
	static void hello(){		//method 정의
		System.out.println("hello");
	}
	
	//sum():정수형 파라메터 2개를 입력받아 그 합을 리턴
	static int sum(int a, int b){
		int sum=a+b;
		return sum;
		
	}
	
	static String getGreeting(String name) {
		return name+" be happy!";
	}
	
	static boolean reverse(boolean flag) {
		return !flag;
	}	
	
	static String result(boolean a, boolean b) {
		if(a&&b) {
			return "ok";
			}
		else {
			return "cancel";
		}
	}
	
	static void loopString(int count, String msg) {
		for (int i = 0; i < count; i++) {
			System.out.println(msg);
		}
	}
	
	static double getArea(int r) {
		return 3.14*r*r;
	}
	
	static void printCircum(int r) {
		System.out.println(r*2*3.14);
	}
	
	static int[] makeArray(int len) {
		 int[] array= new int[len];
		return array;
		
	}
	
	static void total(int[] array) {
		int sum=0;
		
		for (int i=0; i<array.length;i++){
			sum=sum+i;
		}
		System.out.println(sum);
	}
	
	static int[] swap(int[] array, int index1, int index2) {
		int temp=array[index2];
		array[index2]=array[index1];
		array[index1]=temp;
		return array;
	}
	
	static int findMax(int[] array) {
		int max=array[0];
		int index=0;
		for (int i = 1; i < array.length; i++) {
			if(max<array[i]) {
				max=array[i];
				index=i;
			}
		}
		return index;
	}
	
	static int[] reverseArray(int[] array) {
		int length=array.length;
		int reverse[]=new int[length];
		
		for (int i = 0; i < length; i++) {
			reverse[i]=array[length-i-1];
		}
		return reverse;
	}
	
	static void isExist(int[] array, int num) {
		boolean flag=false;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==num) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("exist");
		}
		else {
			System.out.println("not exist");
		}
	}
	
	static boolean equals(int[] arr1, int[] arr2) {
		boolean flag= true;
		
		if(arr1.length==arr2.length) {
			for (int i = 0; i < arr2.length; i++) {
				if(arr1[i]!=arr2[i]) {
					flag=false;
					break;
				}
			}
		}
		else {
			flag=false;
		}
		return flag;
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		int array[]= {1,2,3,4,5,6};
		
		hello();		//method call, 메소드 사용
		int res= sum(1,8);
		System.out.println(res);
		//1
		System.out.println(getGreeting("김동현"));
		//2
		System.out.println(reverse(false));
		//3
		System.out.println(result(true,true));
		//4
		loopString(2,"msg반복");
		//5
		System.out.println(getArea(4));
		//6
		printCircum(4);
		//7
		System.out.println(Arrays.toString(makeArray(3)));
		//8
		total(array);
		//9
		System.out.println(Arrays.toString(swap(array,1,3)));
		//10
		System.out.println(findMax(array));
		//11
		System.out.println(Arrays.toString(reverseArray(array)));
		//12
		isExist(array,3);
		//13
		System.out.println(equals(array,array));
		// TODO Auto-generated method stub

	}
	
	
	

}
