/*
 * Other types of Employees might include Salaried Employees who get paid a fixed weekly salary, PieceWorkers who get paid by the number of pieces they produce or HourlyEmployees who get paid an hourly wage with time and a half - 1.5 times the hourly wage - for hours worked over 40 hours.
 * Create class HourlyEmployee that inherits from class Employee (Exercise 9.14) and has instance variable hours (a double) that represents the hours worked, instance variable wage (a double) that represents the wages per hour, a constructor that takes as arguments a first name, a last name, a social security number, an hourly wage, and the number of hours worked, set and get methods for manipulating the hours and wage, an earnings method to calculate an HourlyEmployee's earnings based on the hours worked and a toString method that returns the HourlyEmployee's String representation.  Method setWage should ensure that wage is nonnegative, and setHours should ensure that the value of hours is between 0 and 168 (the total number of hours in a week).  Use class Hourly Employee in a test program that's similar to the one in Fig. 9.5.
 */

public class HourlyEmployeeTest{
	public static void main(String[] args) {
		HourlyEmployee employee = new HourlyEmployee("Bob", "Lewis", "333-33-3333", 10.50, 30);
		
		System.out.printf("Employee information obtained by get methods:%n");
		System.out.printf("First name is %s%n", employee.getFirstName());
		System.out.printf("Last name is %s%n", employee.getLastName());
		System.out.printf("Social security number is %s%n", employee.getSocialSecurityNumber());
		System.out.printf("Gross sales is %s%n", employee.getWage());
		System.out.printf("Commission rate is %s%n", employee.getHours());
		System.out.printf("Earnings is %s%n", employee.earnings());
		
		employee.setWage(20);
		
		System.out.printf("%nUpdated employee information ontained by toString:%n%n%s%n", employee.toString());
	}
}