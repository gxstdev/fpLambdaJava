package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class E1 {
	public static final File PATH_FILE = new File("C:\\temp\\produtos_tecnologia.csv");

	public static void main(String[] args) {	
		//preço médio		
		BigDecimal avgPrice = getProducts().stream()
				.map(Product::getPrice)
				.reduce(new BigDecimal(0), (a, b) -> a.add(b))
				.divide(new BigDecimal(getProducts().size()), 2, RoundingMode.HALF_UP);
		
		System.out.println("o preço médio dos produtos é: " + avgPrice);	
		
		System.out.println("\nprodutos com preço menor que é a média: ");	
		
		//nomes em ordem --> decrescente 
		//sorted
		getProducts().stream().filter(p -> p.getPrice().compareTo(avgPrice) == -1)
				.map(Product::getName).sorted(Comparator.reverseOrder()).collect(Collectors.toList())
				.forEach(System.out::println);;	
	}

	public static List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		String line;

		try (BufferedReader bf = new BufferedReader(new FileReader(PATH_FILE))) {
			while ((line = bf.readLine()) != null) {
				if (line.contains("NAME") || line.contains("PRICE")) {
					continue;
				}else {
					products.add(convertCsvToProduct(line));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public static Product convertCsvToProduct(String strProduct) {
		String[] atributes = strProduct.split(",");
		return new Product(atributes[0], new BigDecimal(atributes[1]));
	}
}
