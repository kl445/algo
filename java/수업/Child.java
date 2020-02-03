package com.object;

class Truck {

}

class Parent {
	String name = "Tom";
	String address = "seoul";

	// 생성자

	Parent() {
		System.out.println("parent 생성자");
		System.out.println(getClass());
	}

	void printName() {
		System.out.println("name: " + name);
	}

	void printAddress() {
		System.out.println("address: " + address);

	}

}

public class Child extends Parent {
	int age = 25;

	Child() {
		System.out.println("child 생성자");
	}

	
	@Override	//annotation 부모 메소드와 동일해야 되는것(리턴타입,메소드이름,파라메터리스트)
	void printName() {
		// TODO Auto-generated method stub
		System.out.println("name: " + "Tomson");	//메소드 내용만 수정가능
	}
	
	//오버로딩: 한 클래스 안에서 메소드의 파라메타가 다른 경우
	int printName(int a) {
		return 130;
	}
	
	
	
//	void printName() {
//		System.out.println("name: " + "Tomson");
//	}

	void callSuper() {
		super.printName();
	}

	void callThis() {
		this.printName();
	}

	public static void main(String args[]) {
		Parent p = new Parent();
		p.printAddress();
		p.printName();

		Child c = new Child();
		c.printName();
		
		c.callSuper();
		c.callThis();
		c.printAddress();
		
	
	}

}
