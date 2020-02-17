package com.inter;


class Truck{
	
}
interface Other{}


public class ICircle extends Truck implements IShape, Other{

	
	int r;
	
	
	public ICircle(int r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*r*r;
	}

	@Override
	public double getCircum() {
		// TODO Auto-generated method stub
		return Math.PI*r*2;
	}

}
