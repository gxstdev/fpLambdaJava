package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void print(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {

		List<Product> list = Arrays.asList(new Product("SmartPhone Samsumg", 14500.00),
				new Product("Notebook Acer", 3500.00), new Product("Monitor Acer", 1200.00),
				new Product("Table Samsumg", 2500.00));

		List<String> productsName = list.stream()
				.map(new ProductFunctionImpl()).collect(Collectors.toList());

		productsName.forEach(Main::print);
		
		List<Double> productsPrice = list.stream()
				.map(Product::extractProductPrice).collect(Collectors.toList());
		
		productsPrice.forEach(p -> System.out.println(p));
		
		Function<Product, Product2> fun = (p) -> new Product2(p.getName().concat(" 2"), p.getPrice());
		List<Product2> product2s = list.stream().map(fun).collect(Collectors.toList());
		product2s.forEach(System.out::println);
		
		List<Product2> list2 = list.stream().map(p -> {
			return new Product2("product 2", p.getPrice());
		}).collect(Collectors.toList());
		
		list2.forEach(System.out::println);
	}
}
