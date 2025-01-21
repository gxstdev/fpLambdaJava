package predicate;

public class Product {
	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public static boolean productPredicateImpl(Product p) {
		return p.getName().contains("a");
	}
	
	public boolean noStaticProductPredicateImpl() {
		return this.name.contains("e");
	}

	@Override
	public String toString() {
		return String.format("%s, %.2f", name, price);
	}		
}
