package wsjava_09;

import java.util.ArrayList;
import java.util.Scanner;



public class BookTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		BookMgrImpl b = BookMgrImpl.getInstance();
		
		
		
		
		System.out.println("오픈");
		try {
		b.open();
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println("없음");
			
		}
		
		
		
		
		ArrayList<Book> temp=new ArrayList<>();
		System.out.println("모두 검색");
		temp=b.search();
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("책 판매 ");
		try {
		b.sell("3251",10);}
		catch(ISBNNotFoundException e) {
			System.out.println(e);
			}
		catch(QuantityException e2) {
			System.out.println(e2);
		}
		temp=b.search();
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("책 구매");
		try {
		b.buy("88163",5);
		}
		catch(ISBNNotFoundException e) {
			System.out.println(e);
			}
		
		temp=b.search();
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		

		System.out.println("재고 금액");
		System.out.println(b.getTotalAmount());
		System.out.println();
		
		System.out.println("클로즈");
		try {
		b.close();}
		catch(Exception e) {
			System.out.println("저장실패");
			System.out.println(e);
		}

	}

}
