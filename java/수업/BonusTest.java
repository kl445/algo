package com.object;

public class BonusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee tom=new Employee(123,"Tom LEE",300);
		System.out.println(tom.getBonus());
		
		Manager jack= new Manager(456, "jcak KIM", 500, 10152);

		System.out.println(jack.getBonus());
		
		
		Ceo Bill = new Ceo(1,"Bill PARK", 1000, "010-2074-2215");
		System.out.println(Bill.getBonus());
	}

}
