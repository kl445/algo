package wsjava_0204;

public class BookTest {

	int N = 5;
	int index = 0;
	Book[] books;

	public BookTest() {
		books = new Book[N - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BookTest b = new BookTest();

		b.addBook(new Book(1, "수학의정석", "김이박", "김이박출판사", 9000, "113"));
		b.addBook(new Magazine(12, "수학의정석2", "김이박2", "김이박출판사2", 8000, "1134", 12, 5));
		b.addBook(new Novlel(123, "수학의정석3", "김이박3", "김이박출판사3", 11000, "1135", "2323"));
		b.addBook(new Novlel(12355, "수석3", "이박3", "출판사3", 11000, "115535", "23253"));

		System.out.println("get all book: ");
		for (Book book : b.getAllBooks()) {
			if ((book != null)) {
				System.out.println(book.toString());
			}
		}
		System.out.println();
		
		System.out.println("find isbn");
		if ((b.findByIsbn(1) != null)) {
			System.out.println(b.findByIsbn(1).toString());
		}
		
		
		System.out.println();
		System.out.println("find title");
		for (Book book : b.findByTitle("수학의정석")) {
			if ((book != null)) {
				System.out.println(book.toString());
			}
		}


		System.out.println();
		System.out.println("find publisher");
		for (Book book : b.findByPublisher("김이박출판사")) {

			if ((book != null)) {
				System.out.println(book.toString());
			}
		}

		System.out.println();
		System.out.println("find price");
		for (Book book : b.findByPrice(10000)) {
			if ((book != null)) {
				System.out.println(book.toString());
			}
		}


		System.out.println();
		System.out.println("get sum");
		System.out.println(b.getSum());


		System.out.println();
		System.out.println("get avg");
		System.out.println(b.getAvg());

//		Book[] b2 = new Book[3];
//
//		b2[0] = addBook(123, "수학의정석", "김이박", "김이박출판사", 9000, "113");
//		b2[1] = addBook(1234, "수학의정석2", "김이박1", "김이박출판사4", 11000, "114");
//		b2[2] = addBook(12345, "수학의정석3", "김이박2", "김이박출판사5", 10000, "115");
//
//		getAllBooks(b2);
//		findByIsbn(100, b2);
//		findByTitle("수학의정석", b2);
//		findByPublisher("김이박출판사", b2);
//		findByPrice(10000, b2);
//		System.out.println("get Sum : " + getSum(b2));
//		System.out.println("get avg : " + getAverage(b2));

	}

	public void addBook(Book book) {

		if (index < N - 1) {
			books[index] = book;
			index++;
		}

	}

	public Book[] getAllBooks() {

		return books;
	}

	public Book findByIsbn(int isbn) {

		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				return book;
			}
		}
		return null;
	}

	public Book[] findByTitle(String title) {
		Book[] tmp = new Book[N - 1];
		int idx = 0;

		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				tmp[idx] = book;

				idx++;
			}
		}
		return tmp;

	}

	public Book[] findByPublisher(String publisher) {
		Book[] tmp = new Book[N - 1];
		int idx = 0;

		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				tmp[idx] = book;

				idx++;
			}
		}
		return tmp;

	}

	public Book[] findByPrice(int price) {
		Book[] tmp = new Book[N - 1];
		int idx = 0;

		for (Book book : books) {
			if (book.getPrice() <= price) {
				tmp[idx] = book;
				idx++;
			}
		}
		return tmp;

	}

	public int getSum() {
		int sum = 0;
		for (Book book : books) {
			sum += book.getPrice();
		}
		return sum;

	}

	public int getAvg() {
		int sum = 0;
		for (Book book : books) {
			sum += book.getPrice();
		}
		int avg = 0;
		return sum / books.length;

	}

//	public static Book addBook(int isbn, String title, String author, String publisher, int price, String desc) {
//
//		Book b_temp = new Book(isbn, title, author, publisher, price, desc);
//		return b_temp;
//	}
//
//	public static void getAllBooks(Book[] b) {
//		for (int i = 0; i < b.length; i++) {
//			String str = b.toString();
//			System.out.printf(str);
//		}
//	}
//
//	public static void findByIsbn(int isbn, Book[] b) {
//		for (Book value : b) {
//			if (value.getIsbn() == isbn) {
//				String str = b.toString();
//				System.out.println(str);
//
//			}
//		}
//	}
//
//	public static void findByTitle(String title, Book[] b) {
//		for (Book value : b) {
//			if (value.getTitle().equals(title)) {
//				String str = b.toString();
//				System.out.println(str);
//			}
//		}
//	}
//
//	public static void findByPublisher(String publisher, Book[] b) {
//		for (Book value : b) {
//			if (value.getPublisher().equals(publisher)) {
//				String str = b.toString();
//				System.out.println(str);
//			}
//		}
//	}
//
//	public static void findByPrice(int price, Book[] b) {
//		for (Book value : b) {
//			if (value.getPrice() <= price) {
//				String str = b.toString();
//				System.out.println(str);
//			}
//		}
//	}
//
//	public static int getSum(Book[] b) {
//		int sum = 0;
//		for (Book value : b) {
//			sum += value.getPrice();
//		}
//		return sum;
//
//	}
//
//	public static int getAverage(Book[] b) {
//		int sum = getSum(b);
//		int avg = sum / b.length;
//		return avg;
//	}

}
