package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		File f=File.createTempFile("sample", ".txt");
		
		
		//파일에 쓰기
		FileWriter fw =new FileWriter(f);//character stream 종류 (2byte에 한 글자의 코드 정보를 담아서 전송).node stream
		BufferedWriter bw= new BufferedWriter(fw); //process stream
		
		bw.write("안녕하세요");
		bw.newLine();
		bw.write("빨리");
		bw.newLine();		
		bw.write("집에");
		bw.newLine();
		bw.write("가고");
		bw.newLine();		
		bw.write("싶다.");
		bw.newLine();
		
		bw.close();
		fw.close();
		
		//파일에서 읽어오기
		
		FileReader fr= new FileReader(f);//node stream
		BufferedReader br=new BufferedReader(fr);//process stream or file stream
		
		for (String str; (str=br.readLine())!=null;) {
			System.out.println(str);
			
		}
		
		br.close();
		fr.close();
	}

}
