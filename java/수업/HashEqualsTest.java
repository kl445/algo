package com.day0207;


class Book{
	int num;
	String title;
	
	@Override
	public String toString() {
		return "Book [num=" + num + ", title=" + title + "]";
	}


	public Book(int num, String title) {
		this.num = num;
		this.title = title;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 999;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof Book ) {
			Book b=(Book)obj;
			
			if(num==b.num && title.equals(b.title)) {
				return true;
			}
		}
		return false;
	}
	
	
}
public class HashEqualsTest {

	public static void main(String[] args) {

		Book b1= new Book(112,"hello java");
		Book b2= new Book(112,"hello java");
		
		
		System.out.println(b1==b2);
		System.out.println(b1.hashCode());
		System.out.println(b2.hashCode());
		System.out.println(b1.equals(b2));
	}



}
