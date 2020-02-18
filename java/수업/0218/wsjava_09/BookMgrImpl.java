package wsjava_09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {

	ArrayList<Book> books;

	private BookMgrImpl() throws Exception {
//		open();
		 books = new ArrayList<>();
	}

	private static BookMgrImpl instance;

	public static BookMgrImpl getInstance() throws Exception {
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
	public ArrayList<Book> search() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		// TODO Auto-generated method stub

		boolean flag = false;
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				flag = true;
				int temp_quantity = book.getQuantity() - quantity;
				if (temp_quantity >= 0) {
					book.setQuantity(temp_quantity);
				} else {
					throw new QuantityException("판매량이 재고보다 많습니다.");
				}
			} else {

			}
		}
		if (!flag) {
			throw new ISBNNotFoundException("해당하는 ISBN이 없습니다.");
		}

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = false;
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				flag = true;
				int temp_quantity = book.getQuantity() + quantity;
				book.setQuantity(temp_quantity);
			} else {
			}
		}

		if (!flag) {
			throw new ISBNNotFoundException("해당하는 ISBN이 없습니다.");
		}

	}

	@Override
	public int getTotalAmount() {
		int totalPrice = 0;

		for (Book book : books) {
			totalPrice += book.getPrice() * book.getQuantity();
		}
		return totalPrice;
	}

	@Override
	public void open() throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("src\\wsjava_09\\book.dat"); // node stream
		ObjectInputStream ois = new ObjectInputStream(fis); // filter stream

		ArrayList<Book> temp = (ArrayList<Book>) ois.readObject();

		if (temp.size() >0) {
			System.out.println("if");
			books.addAll(temp);
		}else {
			System.out.println("else");
			books.add(new Book("3251", "언어의정석", 13000, 21));
			books.add(new Magazine("88163", "스포츠매거진", 5000,  20, 10));
			books.add(new Magazine("1234", "매거진원투데이", 8000,  5, 11));
		}

		ois.close();
		fis.close();

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

		FileOutputStream fos = new FileOutputStream("src\\wsjava_09\\book.dat"); // node stream
		ObjectOutputStream oos = new ObjectOutputStream(fos); // filter stream

		oos.writeObject(books);

		oos.close();
		fos.close();

	}

}
