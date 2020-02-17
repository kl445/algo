package com.computer;

public abstract class Parts {
	
	private int price;
	private String maker;
	
	

	public Parts(int price, String maker) {
		this.price = price;
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public void info() {
		
		System.out.println("price: "+ price);
		System.out.println("maker: "+ maker);
		
	}
	
	

}
