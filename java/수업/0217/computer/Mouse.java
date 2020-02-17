package com.computer;

public class Mouse extends Parts {

	boolean wireless;
	

	public Mouse(int price, String maker, boolean wireless) {
	
		super(price,maker);
		this.wireless = wireless;
	}
	
	
	public boolean isWireless() {
		return wireless;
	}
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	public void leftClick(){
		System.out.println("Mouse_LeftClick");
		
	}
	public void rightClick(){
		System.out.println("Mouse_RightClick");
		
	}
	public void wheeling(){
		System.out.println("Mouse_wheeling");
		
	}

	
	public void info() {	
		
		super.info();
		System.out.println("wireless: "+wireless);
		System.out.println("------------------------");		
	}
	
}







