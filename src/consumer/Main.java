package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Main {
	public static void main(String[] args) {
		
		List<Product> list = Arrays.asList(
				new Product("Tv", 900.00), 
				new Product("Mouse", 50.00),
				new Product("Tablet", 350.50), 
				new Product("HD Case", 80.90)
				);
		//Consumer tem o método abstract accept() que executa uma ação sobre um objeto 
		//e não retorna nada
		
		//implementação da Consumer a partir de uma classe anônima
		list.forEach(new Consumer<Product>() {
			@Override
			public void accept(Product t) {
				t.setName(t.getName().toUpperCase());
				System.out.println(t);
			}
		});
		
		//implementação a partir de expressão lambda inline
		list.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		System.out.println(list);

		//implementação a partir do objeto de uma classe que implementa a 
		//Consumer
		list.forEach(new ProductConsumerImpl());
		
		//implementação a partir da expressão lambda declarada
		Consumer<Product> cons = System.out::println;
		list.forEach(cons);
		
		//implementação a partir de method reference
		list.forEach(Product::lowerCaseProdName);
		list.forEach(cons);
	}
}
