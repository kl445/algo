package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//직렬화 Serialization - 스트림을 통해 객체가 이동될 때 객체 안의 데이터(필드)가 연속된 바이트 형태로 바뀌어 전송되는 작업
//직렬화 조건: Serialization 인터페이스 구현
class Card implements Serializable{
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card(int num, String name) {
		this.num = num;
		this.name = name;
	}
}

public class CardSave {

	public static void main(String[] args) throws Exception {
		
		
		Card mycard= new Card(123,"tommy lee");
		
	
		//File에 객체 저장		
		FileOutputStream fos= new FileOutputStream("tmp.txt");	//node stream
		ObjectOutputStream oos= new ObjectOutputStream(fos);	//filter stream
		oos.writeObject(mycard);
		
		oos.close();
		fos.close();
		
		
		//File에서 읽어오기
		FileInputStream fis =new FileInputStream("tmp.txt");	//node stream
		ObjectInputStream ois =new ObjectInputStream(fis);		//filter stream
		
		Card newcard=(Card)ois.readObject();
		
		System.out.println(newcard.getNum());
		System.out.println(newcard.getName());

		ois.close();
		fis.close();
		
	}

}
