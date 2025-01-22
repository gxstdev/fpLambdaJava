package function;

import java.util.function.Function;
//T -> classe que será parâmetro para o método apply
//R -> classe que será o retorno do método apply
public class ProductFunctionImpl implements Function<Product, String>{

	@Override
	public String apply(Product t) {
		return t.getName().toUpperCase();
	}

}
