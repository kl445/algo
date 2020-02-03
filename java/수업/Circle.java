package com.object;

public class Circle {

	int r;

	public Circle() {
		this(0);
	}

	public Circle(int r) {
		this.r = r;

	}

	// 생성자 디폴트, r을 받는

//원 둘레

double getCircum(){	
	return 2*3.14*r;
}

double	getArea(){
		return 3.14*r*2;
		

	}

}