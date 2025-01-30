package streams;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 0, 7, 31);
		
		Stream<Integer> stream1 = list.stream();
		
		//Stream<Integer> stream2 = stream1.map(e -> e * 2);
		
		//criamos streams a partir de uma coleção de dados, não de outra stream
		//para não gerar exceptions quando uma das stream tiver um op terminal
		Stream<Integer> stream3 = list.stream().map(e -> e * 2);
		
		//quando executamos uma operação terminal, como toArray em uma stream a
		//stream derivada da stream a, não consegue operar nela
		//então causam a exception -> java.lang.IllegalStateException: stream has already been operated upon or closed
		//stream2 causaria a exception acima
		System.out.println(Arrays.toString(stream1.toArray()));	
		list.stream().map(e -> e * 2).forEach(System.out::println);
		System.out.println(Arrays.toString(stream3.toArray()));

		Stream<String> stream4 = Stream.of("Java", "Python", "Kotlin");
		stream4.forEach(System.out::println);
		
		Stream<Integer> stream5 = Stream.iterate(2, n -> n + 2).limit(12);
		
		stream5.forEach(System.out::println);
	}
}
