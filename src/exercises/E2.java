package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E2 {
	public static final File PATH_FILE = new File("C:\\temp\\funcionarios.csv");

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("digite o salário: ");
		BigDecimal s = input.nextBigDecimal();
		
		System.out.println("funcionários com salário superior a " + s);
		//salario superior a -- s
		getEmployees().stream()
		.filter(e -> e.getSalary().compareTo(s) == 1)
		.map(Employee::getEmail)
		.sorted().collect(Collectors.toList())
		.forEach(System.out::println);
		
		//soma salário de funcionários que o nome começa com m
		BigDecimal salary =  getEmployees().stream()
		.filter(e -> e.getName().charAt(0) == 'M')
		.map(Employee::getSalary)
		.reduce(new BigDecimal(0), (a, b) -> a.add(b));
		
		System.out.println("soma dos salários dos funcionários que o nome começa com M: \n" + salary);
		
		input.close();
	}
	public static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String line;

		try (BufferedReader bf = new BufferedReader(new FileReader(PATH_FILE))) {
			while ((line = bf.readLine()) != null) {		
				employees.add(convertCsvToProduct(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static Employee convertCsvToProduct(String strProduct) {
		String[] atributes = strProduct.split(",");
		return new Employee(atributes[0], atributes[1], new BigDecimal(atributes[2]));
	}
}
