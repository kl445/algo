package com.ssafy;

public class CarMgr {

	private static Car[] cars = new Car[100];
	private static int index;

	private CarMgr() {
	}

	private static CarMgr instance;

	public static CarMgr getInstance() {
		if (instance == null) {
			instance = new CarMgr();
		}
		return instance;
	}

	// 차량 추가
	public void add(Car c) {

		if (index < 100) {
			cars[index++] = c;
		}
		System.out.println(index);
	}

	// 모든 차량
	public Car[] search() {

		return cars;

	}

	// 전달받은 번호의 차량
	public Car search(String num) {

		for (Car car : cars) {
			if (car != null) {
				if (car.getNum().equals(num)) {
					return car;
				}
			}
		}
		return null;
	}

	// 전달된 가격보다 작은 차량
	public Car[] search(int price) {
		Car[] temp = new Car[100];
		int idx = 0;
		for (Car car : cars) {
			if(car!=null) {
			if (car.getPrice() <= price) {
				temp[idx++] = car;
			}
			}
		}
		return temp;

	}

	// 전달된 번호의 차량 가격 수정
	public void update(String num, int price) {
		for (Car car : cars) {
			if(car!=null) {
			if (car.getNum().equals(num)) {
				car.setPrice(price);
			}
			}
		}
	}

	// 전달된 차량 삭제
	public void delete(String num) {

	
		int idx = 0;
		for (Car car : cars ) {
			if(car!=null ) {
			if (car.getNum().equals(num)) {
				index--;
			}
			}
		}
	
		for (Car car : cars ) {
			if(car!=null && idx<index ) {
		
				if (car.getNum().equals(num)) {
				}
				else {
					cars[idx++]=car;
				}
			}
		}
		cars[index]=null;

	}

	// 배열속 차량 수 리턴
	public int size() {

		int size = 0;
		for (Car car : cars) {
			if (car != null) {
				size++;
			}
		}
		return size;

	}

	// 배열의 총 가격
	public int totalPrice() {

		int totalprice = 0;
		for (Car car : cars) {
			if (car != null) {
				totalprice += car.getPrice();
			}
		}
		return totalprice;

	}

}
