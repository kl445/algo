package wsjava_09;

public class Novel extends Book {

	private String genre;

	public Novel(String isbn, String title,int price,  String genre, int quantity) {
		super(isbn, title,  price,quantity);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString()+" genre=" + genre + "";
	}
	
}
