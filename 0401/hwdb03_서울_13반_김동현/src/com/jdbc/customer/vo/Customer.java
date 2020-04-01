package com.jdbc.customer.vo;

//vo (value object: 값을 저장하기 위한 용도의 객체.)
//customer 테이블 안의 레코드 한건의 정보를 저장하기 위한 목적의 객체
public class Customer {
	private int num;
	private String name;
	private String address;
	
	public Customer() {}
	public Customer(int num, String name, String address) {
		super();
		this.num = num;
		this.name = name;
		this.address = address;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
