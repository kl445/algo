package hwjava_0204;

public class ProductMgr {

	int N = 5;
	int index;
	Product[] products;

	public ProductMgr() {
		products = new Product[N - 1];

	}
	
	public void addProduct(Product product) {
		
		if (index < N - 1) {
			products[index] = product;
			index++;
		}
		
		
	}

	public Product[] getAllProduct() {

		return products;
	}

	public Product findByNum(int num) {

		for (Product product : products) {
			if (product.getNum() == num) {
				return product;
			}
		}
		return null;
	}

	public Product[] findByName(String name) {
		Product[] tmp = new Product[N - 1];
		int idx = 0;

		for (Product product : products) {
			if (product.getName().contains((name))) {
				tmp[idx] = product;
				idx++;
			}
		}
		return tmp;

	}

	public Product[] findTV() {
		Product[] tmp = new Product[N - 1];
		int idx = 0;

		for (Product product : products) {
			if (product.getClass() == TV.class) {
				tmp[idx] = product;
				idx++;
			}
		}
		return tmp;

	}

	public Product[] findRefrigerator() {
		Product[] tmp = new Product[N - 1];
		int idx = 0;

		for (Product product : products) {
			if (product.getClass() == Refrigerator.class) {
				tmp[idx] = product;
				idx++;
			}
		}
		return tmp;

	}

	public Product[] deleteByNum(int num) {

		Product[] tmp = new Product[N - 1];
		int idx = 0;
		
		for (Product product : products) {
			if (product.getNum() != num) {
				if (idx < N - 1) {
					tmp[idx] = product;
					idx++;
				}
			}
		}
		return tmp;
		
	}

	public int getAllStockPrice() {
		int sum = 0;
		for (Product product : products) {
			sum += product.getStock() * product.getPrice();
		}
		return sum;

	}
	public void isNull() {
		System.out.println("더이상 해당하는 제품이 없습니다.");
	}

}
