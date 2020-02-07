package com.ssafy;

import java.util.Arrays;

public class CarTest {

	public static void main(String[] args) {

		CarMgr mgr= CarMgr.getInstance();
		
		mgr.add(new Car("1","sonata",100000));
		mgr.add(new Bus("2","miniBus",500000,20));
		mgr.add(new Truck("3","jeppTruck",300000,1));
		mgr.add(new Bus("4","bugBus",1000000,45));
		mgr.add(new Car("5","k7",200000));
		
		
		
		//search()
		System.out.println("search(): ");
		Car[] temp=mgr.search();
		for (Car value:temp) {
			if(value!=null)
			System.out.println(value);
		}
		System.out.println();
		
		//search(String num)
		String num="2";
		System.out.println("search(String num): "+num);
		if(mgr.search(num)!=null)
			System.out.println(mgr.search(num));
		else
			System.out.println("null");
		System.out.println();
		
		
		//search(int price)
		int price=200000;
		System.out.println("search(int price): "+price);
		temp=mgr.search(price);
		for (Car value : temp) {
			if(value!=null)
				System.out.println(value);
			else {
				System.out.println("null");
				break;
			}
		}
		System.out.println();
		
		
		//update(String num, int price)
		num="3";
		price=400000;
		System.out.println("update(String num "+num+", int price"+price+")");
		System.out.println("Before "+mgr.search(num));
		mgr.update(num, price);
		System.out.println("After "+mgr.search(num));
		System.out.println();
		
		
		//delete(String num)
		num="2";
		System.out.println("delete(String num)"+num);
		System.out.println("Before "+mgr.search(num));
		mgr.delete(num);
		System.out.print("After ");
		System.out.println(mgr.search(num));

		System.out.println();
		
		
		//search()
				System.out.println("search(): ");
				 temp=mgr.search();
				for (Car value:temp) {
					if(value!=null)
					System.out.println(value);
				}
				System.out.println();
		
		
		//size()
		System.out.println("size()");
		System.out.println(mgr.size());
		
		
		//totalPrice()
		System.out.println("totalPrice()");
		System.out.println(mgr.totalPrice());
	}

}
