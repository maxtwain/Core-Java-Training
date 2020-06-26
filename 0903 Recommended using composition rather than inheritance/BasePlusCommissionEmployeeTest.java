/*
 * Many programs written with inheritance could be written with composition instead, and vice versa.  Rewrite class BasePlusCommissionEmployee (Fig. 9.11) of the CommissionEmployee-BasePlusCommissionEmployee hierarchy so that it contains a reference to a CommissionEmployee object, rather than inheriting from class CommissionEmployee.  Retest BasePlusCommissionEmployee to demonstrate that it still provides the same functionality.
 */

public class BasePlusCommissionEmployeeTest {
   public static void main(String[] args) {
	   CommissionEmployee comEmp = new CommissionEmployee(
			   "Bob", "Lewis", "333-33-3333", 5000, .04);
      BasePlusCommissionEmployee employee =             
         new BasePlusCommissionEmployee(                
         300, comEmp);
      
      System.out.println(
         "Employee information obtained by get methods:");
      System.out.printf("%s %s%n", "First name is",
         employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", 
         employee.getLastName());
      System.out.printf("%s %s%n", "Social security number is", 
         employee.getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Gross sales is", 
         employee.getGrossSales());
      System.out.printf("%s %.2f%n", "Commission rate is",
         employee.getCommissionRate());
      System.out.printf("%s %.2f%n", "Base salary is",
         employee.getBaseSalary());

      employee.setBaseSalary(1000); 
      
      System.out.printf("%n%s:%n%n%s%n", 
         "Updated employee information obtained by toString", 
          employee.toString());
   } 
} 
