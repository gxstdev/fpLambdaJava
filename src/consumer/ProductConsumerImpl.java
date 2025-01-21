package consumer;

import java.util.function.Consumer;

public class ProductConsumerImpl implements Consumer<Product>{

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() / 1.1);
	}

}
