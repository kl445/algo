package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis;		//읽기 스트림
		FileOutputStream fos;		//쓰기 스트림
		
		
		fis=new FileInputStream("com\\exception\\ArrayTest.java");	//원본
		fos= new FileOutputStream("com\\io\\FileCopy2.java");	//복사본
		
		
		for (int i = 0; (i=fis.read())!=-1;) {
			fos.write(i);
		}
		
		fis.close();
		fos.close();
		
		System.out.println("file copied.");
	}

}
