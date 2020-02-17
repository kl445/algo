package com.computer;

public class KeyBoard extends Parts{
	
	
	private String type;	
	
	
	public KeyBoard(int price,String type, String maker) {
		super(price,maker);
		this.type = type;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}




	




	public void typing(){
		System.out.println("KeyBoard typing...");
		System.out.println("----------");
	}
	
	
	public void info() {

		super.info();
		System.out.println("type: "+ type);
		System.out.println("------------------------");
	}
	
}
