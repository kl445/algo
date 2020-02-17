package com.inter;

public class IRect implements IShape {
	
	int width;
	int height;
	
	

	public IRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}

	@Override
	public double getCircum() {
		// TODO Auto-generated method stub
		return 2*(width+height);
	}

}
