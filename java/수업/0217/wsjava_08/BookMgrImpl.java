package wsjava_08;

import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {

	ArrayList<Book> books = new ArrayList<>();
	
	private BookMgrImpl() {
	}

	private static BookMgrImpl instance;

	public static BookMgrImpl getInstance() {
		if (instance == null) {
			instance = new BookMgrImpl();
		}
		return instance;
	}

	

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		books.add(book);
	}

	@Override
	public ArrayList<Book> total() {
		// TODO Auto-generated method stub

		return books;
	}

	@Override
	public Book findByIsbn(String Isbn) {
		// TODO Auto-generated method stub

		for (Book book : books) {
			if (book.getIsbn().equals(Isbn)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Book> findByTitle(String title) {
		// TODO Auto-generated method stub

		ArrayList<Book> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getTitle().contains(title)) {
				temp.add(book);
			}
		}

		return temp;
	}

	@Override
	public ArrayList<Magazine> findMagazine() {

		ArrayList<Magazine> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getClass() == Magazine.class) {
				temp.add((Magazine) book);
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Magazine> findMagazine_year(int year) {
		ArrayList<Magazine> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getClass() == Magazine.class && book instanceof Magazine) {
				if (((Magazine) book).getYear() == 2020) {

					temp.add((Magazine) book);
				}
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) {

		ArrayList<Book> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Novel> findNovel() {

		ArrayList<Novel> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getClass() == Novel.class) {
				temp.add((Novel) book);
			}

		}

		return temp;
	}

	@Override
	public ArrayList<Book> findByPrice(int price) {

		ArrayList<Book> temp = new ArrayList<>();

		for (Book book : books) {
			if (book.getPrice() < price) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public int sum() {

		int sum = 0;
		for (Book book : books) {
			sum += book.getPrice();
		}
		return sum;
	}

	@Override
	public double average() {

		int avg = 0;
		if (books.size() != 0) {
			avg = sum() / books.size();
		}
		// TODO Auto-generated method stub
		return avg;
	}

}
