package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


//checked exception: fileinputstream,interrupted
//예외처리가 되어야 컴파일 가능
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		Thread t = new Thread();
		try {
		Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello World");
		
		try {
			FileInputStream fis= new FileInputStream("mystory.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("end");
	}

}
