package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FuncVsOOP {
	public static List<String> convertNumberToString(List<Integer> listIntegersNum) {
		List<String> listStringNum = new ArrayList<String>();
		
		for (Integer integer : listIntegersNum) {
			switch (integer) {
			case 0:
				listStringNum.add("zero") ;
				break;
			case 7:
				listStringNum.add("sete");
				break;
			case 12:
				listStringNum.add("doze");
				break;
			default:
				listStringNum.add("trinta e um");
			}
		}
		
		return listStringNum;
	}
	public static void main(String[] args) {
		List<Integer> listIntegersNum = Arrays.asList(12, 0, 7, 31);
		List<String> listStringNum = Arrays.asList("doze", "zero", "sete", "trinta e um");

		Stream<String> s1 = listIntegersNum.stream().sorted().map(x -> {
			return extracted(x);
		});

		System.out.println(Arrays.toString(s1.toArray()));

		Stream<String> s2 = listIntegersNum.stream().map(FuncVsOOP::extracted);
		
		System.out.println(Arrays.toString(s2.toArray()));
		
		List<String> list1 = convertNumberToString(listIntegersNum);
		System.out.println(list1);
		
		listIntegersNum.sort((a, b) -> a.compareTo(b));
		List<String> list2 = convertNumberToString(listIntegersNum);
		System.out.println(list2);
	}
	public static String extracted(Integer x) {
		switch (x) {
		case 0:
			return "zero";
		case 7:
			return "sete";
		case 12:
			return "doze";
		default:
			return "trinta e um";
		}
	}
}
