package predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
			
		//passando um objeto da classe que implementa a interface Predicate
		//para cada objeto da list, irá executar o método abstrato
		//implementado pela ProductPredicateImpl
		list.removeIf(new ProductPredicateImpl());	
		System.out.println(list);
		
		//implementação da Predicate através de uma classe anônima
		list.removeIf(new Predicate<Product>() {
			@Override
			public boolean test(Product p) {
				// TODO Auto-generated method stub
				return p.getPrice() <= 90.0;
			}		
		});		
		System.out.println(list);
		
		//implementação da interface Predicate através de static reference method
		//cada objeto do tipo Product será passado como parâmetro para o static 
		//method productPredicateImpl
		list.removeIf(Product::productPredicateImpl);
		System.out.println(list);
		
		//implementação da interface Predicate através de não static reference method	
		//cada objeto do tipo Product irá chamar o método noStaticProductPredicateImpl
		list.removeIf(Product::noStaticProductPredicateImpl);
		System.out.println(list);
		
		//implementação da interface Predicate através expressão lambda declarada	
		//essa forma é ideal quando queremos pegar valores externos,
		//como valores digitados pelo usuário
		String value = input.next();
		
		Predicate<Product> pred = p -> {
			return p.getName().contains(value);
		};
		
		list.removeIf(pred);
		System.out.println(list);
		
		//implementação da interface Predicate através expressão lambda inline
		list.removeIf(p -> p.getPrice() >= 60.0);
		System.out.println(list);
	}
}
