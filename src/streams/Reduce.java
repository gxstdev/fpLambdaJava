package streams;

import java.util.Arrays;
import java.util.List;

public class Reduce {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("G", "a","b","r","i","e","l","a");
		//"" - identity / valor inicial
		//r - partial result / r guarda os valores já agregados da stream
		//s - cada elemento da stream
		String name = list.stream().reduce("", (r, s) -> r.concat(s));
		
		System.out.println(name);
	}
}
