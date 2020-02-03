package com.object;

class Employee{
	
	int num;
	String name;
	int salary;
	
	double getBonus() {
		return salary*0.1;
	}

	public Employee() {
	}
	
	public Employee(int num,String name, int salary) {
		this.name=name;
		this.num = num;
		this.salary = salary;
	}
	
}

public class Manager extends Employee{
	int mcode;
	
	public Manager(int num, String name, int salary, int mcode) {
		super(num,name,salary);
//		this.num=num;
//		this.name=name;
//		this.salary=salary;
		this.mcode=mcode;
	}
	double getBonus() {
		return salary*0.3;
	}
	

}

 class Ceo extends Employee{
	String tel;
	
	public Ceo(int num, String name, int salary, String tel) {
		super(num,name,salary);
		this.tel=tel;
	}
	
	double getBonus() {
		return salary*0.5;
		
	}
}
