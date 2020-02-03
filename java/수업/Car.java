package com.object;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Car {
	
	int num=10;
	String model="fox";
	String owner="Mr.f";
	
	public Car() {
		this(5);
	}	
//	public Car(int num) {
//		
//	}	
//	public Car(int num, String model) {
//		
//	}	
//	public Car(int num, String model, String owner) {
//		this.model=model;
//		this.num=num;
//		this.owner=owner;
//		
//	}
	
	public void run() {
		System.out.println("RUN");
	}
	
	public Car(int num) {
	
	this.num = num;
	 //생성자 안에서 다른 생성자 호출
}
	public Car(int num, String model) {
		this.num = num;
		this.model = model;
	}
	public Car(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
	}
	void stop() {
		System.out.println("STOP");
	}
	
	void info() {
		System.out.println("run :"+num);
		System.out.println("model :"+model);
		System.out.println("owner :"+owner);
	}
	
	public static void main(String args[]) {
		Car c1=new Car();
		Car c2=new Car(4578);
		Car c3=new Car(6856,"grandeur");
		Car c4=new Car(7712,"avante","Lee");
		
		c1.info();
		c2.info();
		c3.info();
		c4.info();
		
		
		Frame f= new Frame("TEST");
		f.setLayout(new FlowLayout());
		Button b= new Button("ok");
		Button b2= new Button("Cancel");
		
		Checkbox ch= new Checkbox("one");
		Checkbox ch2= new Checkbox("two",true);
		Checkbox ch3= new Checkbox("three",false);
		f.add(b);
		f.add(b2);
		f.add(ch);
		f.add(ch2);
		f.add(ch3);
		f.setSize(500, 500);
		f.setVisible(true);
		
		
	}
	
	
	
	

}
