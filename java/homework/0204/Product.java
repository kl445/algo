package hwjava_0204;

public class Product {
	
	private int num;
	private String name;
	private int price;
	private int stock;
	public Product(int num, String name, int price, int stock) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [num=" + num + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
