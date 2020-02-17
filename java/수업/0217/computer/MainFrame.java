package com.computer;

public class MainFrame extends Parts{


	public MainFrame(int price,String maker, String cpu) {
		super(price,maker);
		this.cpu = cpu;
	}




	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	private String maker;
	private String cpu;
	
	public void powerOn(){
		System.out.println("MainFrame_PowerOn");
		
	}
	public void powerOff(){
		System.out.println("MainFrame_PowerOff");
		
	}

	
	public void info() {		
				
		super.info();
		System.out.println("cpu: "+cpu);
		System.out.println("------------------------");
		
	}
	
}








