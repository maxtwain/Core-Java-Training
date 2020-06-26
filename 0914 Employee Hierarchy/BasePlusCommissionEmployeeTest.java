/*
 * In this chapter, you studied an inheritance hierarchy in which class BasePlusCommissionEmployee inherited from class CommissionEmployee.  However, not all types of employees are CommissionEmployees.  In this exercise, you'll create a more general Employee superclass that factors out the attributes and behaviors in class CommissionEmployee that are common to all Employees.  The common attributes and behaviors for all Employees are firstName, lastName, socialSecurityNumber, getFirstName, getLastName, getSocialSecurityNumber, and a portion of method toString.  Create a new superclass Employee that contains these instance variables and methods and a constructor.  Next, rewrite class CommissionEmployee from Section 9.4.5 as a subclass of Employee.  Class CommissionEmployee should contain only the instance variables and methods that are not declared in superclass Employee.  Class CommissionEmployee's constructor should invoke class Emlpoyee's constructor, and CommissionEmployee's toString method should invoke Employee's toString method.  Once you've completed these modifications, run the CommissionEmployeeTest and BasePlusCommissionEmployeeTest apps using these new classes to ensure that the apps still display the same results for a CommissionEmployee object and BasePlusCommissionEmployee object, respectively.
 */

public class BasePlusCommissionEmployeeTest{
	public static void main(String[] args) {
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300);
		
		System.out.printf("Employee information obtained by get methods:%n");
		System.out.printf("First name is %s%n", employee.getFirstName());
		System.out.printf("Last name is %s%n", employee.getLastName());
		System.out.printf("Social security number is %s%n", employee.getSocialSecurityNumber());
		System.out.printf("Gross sales is %s%n", employee.getGrossSales());
		System.out.printf("Commission rate is %s%n", employee.getCommissionRate());
		System.out.printf("Base salary is %s%n", employee.getBaseSalary());
		
		employee.setBaseSalary(1000);
		
		System.out.printf("%nUpdated employee information ontained by toString:%n%n%s%n", employee.toString());
	}
}