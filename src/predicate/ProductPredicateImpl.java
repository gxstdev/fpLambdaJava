package predicate;

import java.util.function.Predicate;

public class ProductPredicateImpl implements Predicate<Product>{

	@Override
	public boolean test(Product p) {		
		return p.getName().contains("a");
	}
}
