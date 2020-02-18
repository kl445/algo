package wsjava_09;

public class Magazine extends Book {
	private int year;
	private int month;
	
	public Magazine(String isbn, String title, int price, int quantity, int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() +" year=" + year + ", month=" + month + "]";
	}
	
	

}
