package funcitionalImplComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comparator.Product;

public class Main {
	public static void main(String[] args) {
		
		List<Product> list = Arrays.asList(
				new Product("SmartPhone Samsumg", 14500.00),
				new Product("Notebook Acer", 3500.00),
				new Product("Monitor Acer", 1200.00),
				new Product("Table Samsumg", 2500.00)
				);	
		
//		Comparator<Product> comp = (p1, p2) -> {
//			return p1.getPrice().compareTo(p2.getPrice());
//		};
		
		Comparator<Product> comp = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
		
		
		Collections.sort(list, comp);
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		System.out.println();
		
		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for (Product product : list) {
			System.out.println(product);
		}
	
	}
}
