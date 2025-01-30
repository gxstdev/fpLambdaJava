package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluation {
	public static void executed() {
		System.out.println("executed");
	}
	
	public static void main(String[] args) {
			 
		List<Integer> list = Arrays.asList(12, 0, 7, 31);
		
		Stream<String> s1 = list.stream().map(i -> {
			//operações intermediárias só são executados quando uma operação final é acionada
			//o .map só é executado após o forEach nesse exemplo
			//map - operação intermediária
			//forEach - operação terminal
			//testar em debug
			executed();
			return i % 2 == 0 ? "par" : "impar";
		});
		
		s1.forEach(System.out::println);
		
		System.out.println();
	}
}
