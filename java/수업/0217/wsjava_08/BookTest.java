package wsjava_08;

import java.util.ArrayList;
import java.util.Scanner;



public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		BookMgrImpl b = BookMgrImpl.getInstance();
		
		
		
		
		b.add(new Book("3251", "언어의정석", "김땅땅","땅땅출판사" , 13000, "21"));
		b.add(new Magazine("88163", "스포츠매거진", "편집부", "주스포츠", 5000, "335", 2020, 01));
		b.add(new Novel("8321", "싸피밀실사건", "이스릴", "나뭇가지", 20000, "1231", "이스릴"));
		
		ArrayList<Book> temp=new ArrayList<>();
		System.out.println("모두 검색");
		temp=b.total();
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("isbn 검색");
		System.out.println(b.findByIsbn("3251"));
		System.out.println();
		
		System.out.println("타이틀검색");
		temp=b.findByTitle("언어");
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("노블검색");
		ArrayList<Novel> noveltemp=new ArrayList<>();
		noveltemp=b.findNovel();
		for (Book book : noveltemp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("매거진검색");
		ArrayList<Magazine> Magazinetemp=new ArrayList<>();
		Magazinetemp=b.findMagazine();
		for (Book book : Magazinetemp) {
			System.out.println(book);
		}
		System.out.println();
		
		
		System.out.println("올해 매거진검색");
		Magazinetemp=b.findMagazine_year(2020);
		for (Book book : Magazinetemp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("출판사검색");
		temp=b.findByPublisher("나뭇가지");
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("가격검색");
		temp=b.findByPrice(15000);
		for (Book book : temp) {
			System.out.println(book);
		}
		System.out.println();
		
		System.out.println("도서금액 합계");
		System.out.println(b.sum());
		System.out.println();
		
		System.out.println("도서금액 평균");
		System.out.println(b.average());
		System.out.println();

	}

}
