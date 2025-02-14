package consumer;

import java.util.jar.Attributes.Name;

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

	public static void lowerCaseProdName(Product p) {
		p.setName(p.getName().toLowerCase());
	}
	
	public void noStaticLowerCaseProdName() {
		setName(name.toLowerCase());
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.2f", name, price);
	}		
}
