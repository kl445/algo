package hwjava_0204;

public class ProductTest {
	
	public static void main(String args[]) {
		
		ProductMgr p = new ProductMgr();

		p.addProduct(new TV(1, "3D올레드티비", 1000000, 5));
		p.addProduct(new Refrigerator(2, "올레드색김치냉장고", 500000, 2));
		p.addProduct(new TV(3, "그냥올레드티비", 800000, 7));
		p.addProduct(new Refrigerator(4, "양문냉장고", 1200000, 1));
		
		
		System.out.println("getAllProduct: ");
		for (Product product : p.getAllProduct()) {
			if ((product != null)) {
				System.out.println(product.toString());
			}else {
				p.isNull();
			}
		}
		System.out.println();
		
		System.out.println("findByNum: 1");
		if ((p.findByNum(1) != null)) {
			System.out.println(p.findByNum(1).toString());
		}else {
			p.isNull();
		}
		
		
		System.out.println();
		System.out.println("findByName: 올레드");
		for (Product product : p.findByName("올레드")) {
			if ((product != null)) {
				System.out.println(product.toString());
			}else {
				p.isNull();
				break;
			}
			
		}


		System.out.println();
		System.out.println("findTV");
		for (Product product : p.findTV()) {

			if ((product != null)) {
				System.out.println(product.toString());
			}
			else {
				p.isNull();
				break;
			}
		}
		
		System.out.println();
		System.out.println("findRefrigerator");
		for (Product product : p.findRefrigerator()) {
			
			if ((product != null)) {
				System.out.println(product.toString());
			}
			else {
				p.isNull();
				break;
			}
		}


		System.out.println();
		System.out.println("getAllStockPrice");
		System.out.println(p.getAllStockPrice());
		
		System.out.println();
		System.out.println("deleteByNum : 1");
		for (Product product : p.deleteByNum(1)) {
			
			if ((product != null)) {
				System.out.println(product.toString());
			}
			else {
				p.isNull();
				break;
			}
		}
	


	
		
		
		
		
	}
	

}
