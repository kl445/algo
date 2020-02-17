package com.computer;

public class MyComputer {

	//앞서만든 부품 4개가 들어올 예정
	
	private Mouse mouse;
	private MainFrame frame;
	private KeyBoard keyboard;
	private Monitor monitor;
	
	
	public MyComputer() {

	//필드 4개 생성
		
		mouse= new Mouse(20000,"samsung",true);
		frame= new MainFrame(25000, "samsung", "i9");
		keyboard= new KeyBoard(15000, "membrain", "LG");
		monitor= new Monitor(250000, "LG", 25);
		
		
	
	}
	
	//monitor, frame의 전원키기
	public void powerOn() {
		frame.powerOn();
		monitor.powerOn();
	}
	//monitor, frame 의 전원끄기
	public void powerOff() {
		frame.powerOff();
		monitor.powerOff();
	}
	//keyboard typing, mouse left click, right click, whheeling, click, keyboard typing
	public void doJob() {
		keyboard.typing();
		mouse.leftClick();
		mouse.rightClick();
		mouse.wheeling();
		
	}
	public void info() {
		keyboard.info();
		monitor.info();
		frame.info();
		mouse.info();
	}
	
	
	
	
	
	
	
}
