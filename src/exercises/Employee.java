package exercises;

import java.math.BigDecimal;

public class Employee {
	private String name;
	private String email;
	private BigDecimal salary;
	
	public Employee(String name, String email, BigDecimal salary) {
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %.2f", name, email, salary);
	}	
}
