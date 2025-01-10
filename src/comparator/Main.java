package comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		List<Product> list = Arrays.asList(
				new Product("SmartPhone Samsumg", 14500.00),
				new Product("Notebook Acer", 3500.00),
				new Product("Monitor Acer", 1200.00),
				new Product("Table Samsumg", 2500.00)
				);
		
		//uma forma de se implementar a Comparator
		list.sort(new MyComparator());	
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		//outra forma de se implementar a Comparator
		//com uma classe anônima
		Comparator<Product> comp = new Comparator<Product>() {		
			@Override
			public int compare(Product o1, Product o2) {		
				return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
			}
		};
	
		Collections.sort(list, comp);

		System.out.println();
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		//classe anônima diretamente como parâmetro
		list.sort(new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				if (o1.getPrice() < o2.getPrice()) {
					return -1;
				}
				if (o1.getPrice() == o2.getPrice()) {
					return 0;
				}
				return 1;
			}
		});
		
		for (Product product : list) {
			System.out.println(product);
		}
		
	}
}
