package com.jdbc.customer.app;

import java.util.ArrayList;

import com.jdbc.customer.dao.CustomerDAO;
import com.jdbc.customer.dao.CustomerDAOImpl;
import com.jdbc.customer.vo.Customer;

public class CustomerTest {

	public static void main(String[] args) {

		CustomerDAO dao=new CustomerDAOImpl();
		
//		1.findaAll()
		System.out.println("FindALL");
		ArrayList<Customer> list= dao.findAll();
		for (Customer c : list) {
			System.out.println(c);
			
		}
		System.out.println();
		
//		2.findByNum()
		System.out.println("FindByNum");
		System.out.println(dao.findByNum("211"));
		System.out.println();
		
//		3. findByAddress()
		System.out.println("findByAddress");
		list= dao.findByAddress("la");
		for (Customer c : list) {
			System.out.println(c);
			
		}
		System.out.println();
		
//		4. insert()
		System.out.println("insert");
		int insert_num=dao.insert(new Customer(599,"Ohgugu","moskba"));
		System.out.println(insert_num+"개 추가 완료");
		System.out.println();
	
		System.out.println("FindALL");
		list= dao.findAll();
		for (Customer c : list) {
			System.out.println(c);
			
		}
		System.out.println();
		
		
//		4. delete()
		System.out.println("delete");
		int delete_num=dao.delete("599");
		System.out.println(delete_num+"개 삭제 완료");
		System.out.println();
		System.out.println("FindALL");
		list= dao.findAll();
		for (Customer c : list) {
			System.out.println(c);
			
		}
		
//		5. update()
		System.out.println("update");
		int update_num=dao.update(new Customer(911,"short","newyork"));
		System.out.println(update_num+"개 수정 완료");
		System.out.println();
		System.out.println("FindALL");
		list= dao.findAll();
		for (Customer c : list) {
			System.out.println(c);
			
		}
		System.out.println();
		
	}

}
