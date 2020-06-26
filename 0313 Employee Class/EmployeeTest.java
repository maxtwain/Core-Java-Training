/*
 * Create a class called Employee that includes 
 * three instance variables - a first
 * name (type String), a last name (type String), 
 * and a monthly salary (double).  Provide a constructor
 * that initializes the three instance variables.  
 * Provide a set and a get method for each instance variable.
 * If the monthly salary is not positive, do not set its 
 * value.  Write a test app name EmployeeTest that
 * demonstrates class Employee's capabilities.  Create two 
 * Employee objects and display each object's
 * yearly salary.  Then give each Employee a 10% raise and 
 * display each Employee's yearly salary again.
 */

public class EmployeeTest{
	public static void main(String[] args) {
		Employee e0 = new Employee("Adam", "Smith", 5.43);
		Employee e1 = new Employee("Bernie", "Calhoon", -5.43);
		
		System.out.printf("%10s%10s%10s%n", "firstName", "lastName", "salary");
		
		System.out.printf("%10s%10s%10.2f%n", e0.getFirstName(),
				e0.getLastName(), e0.getSalary());
		System.out.printf("%10s%10s%10.2f%n", e1.getFirstName(),
				e1.getLastName(), e1.getSalary());
		
		e0.setFirstName("Carl");
		e0.setLastName("Monahan");
		e0.setSalary(-5.55);
		
		e1.setSalary(10.44);
		
		System.out.printf("%10s%10s%10.2f%n", e0.getFirstName(),
				e0.getLastName(), e0.getSalary());
		System.out.printf("%10s%10s%10.2f%n", e1.getFirstName(),
				e1.getLastName(), e1.getSalary());
	}
}