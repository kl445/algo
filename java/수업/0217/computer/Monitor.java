package com.computer;

public class Monitor extends Parts {
	private double size;	

	

	public Monitor(int price, String maker,double size) {

		super(price,maker);
		this.size = size;
	}
	

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public void powerOn(){
		System.out.println("Monitor_PowerOn");	
	}

	public void powerOff(){
		System.out.println("Monitor_PowerOff");	
		
	}

	
	public void info() {
		
		super.info();
		System.out.println("size: "+size);
		System.out.println("------------------------");
		
	}
	
}


