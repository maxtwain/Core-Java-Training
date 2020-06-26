/*
 * In this exercise, we modify the accounts payable application of Figs. 10.11 - 10.14 to include the complete functionality of the payroll application of Figs. 10.4 - 10.9.  The application should still process two Invoice objects, but now should process one object of each of the four Employee subclasses.  If the object currently being processed is a BasePlusCommissionEmployee, the application should increase the BasePlusCommissionEmployee's base salary by 10%.  Finally, the application should output the payment amount for each object.  Complete the following steps to create the new application:
 * 
 * A) Modify classes HourlyEmployee (Fig. 10.6) and CommissionEmployee (Fig.10.7) to place them in the Payable hierarchy as subclasses of the version of Employee (Fig 10.13) that implements Payable.  [Hint: Change the name of method earnings to getPaymentAmount in each subclass so that the class satisfies its inherited contract with interface Payable.]
 * 
 * B) Modify class BasePlusCommissionEmployee (Fig. 10.8) such that it extends the version of class CommissionEmployee created in part (a).
 * 
 * C) Modify PayableInterfaceTest (Fig. 10.14) to polymorphically process two Invoices, one SalariedEmployee, one HourlyEmployee, one CommissionEmployee, and one BasePlusCommissionEmployee.  First output a String representation of each Payable object.  Next, if an object is a BasePlusCommissionEmployee, increase its base salary by 10%.  Finally, output the payment amount for each Payable object.
 * 
 * 
 * 
 * My notes:
 * I doubt whether the authors read their own code for this exercise.  Employee transitions getPaymentAmount() to earnings() for its children.  Part A and part B are already functional.
 */

public class PayableInterfaceTest {
	public static void main(String[] args) {
		Payable[] payableObjects = new Payable[] { 
				new Invoice("01234", "seat", 2, 375.00),
				new Invoice("56789", "tire", 4, 79.95), 
				new SalariedEmployee("John", "Smith", "111-11-1111", 800.00),
				new HourlyEmployee("Lisa", "Barnes", "888-88-8888", 20.00, 10.00),
				new CommissionEmployee("John", "Burges", "222-22-2222", 2000.00, 0.05),
				new BasePlusCommissionEmployee("Joe", "Cool", "333-33-3333", 2000, 0.04, 600),
		};

		System.out.println("Invoices and Employees processed polymorphically:");

		for (Payable currentPayable : payableObjects) {
			System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(),
					currentPayable.getPaymentAmount());
		}
		
		for (Payable currentPayable : payableObjects) {
			if (currentPayable instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee base = (BasePlusCommissionEmployee) currentPayable;
				base.setBaseSalary(base.getBaseSalary() * 1.1);
				currentPayable = base;
			}
			System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(),
						currentPayable.getPaymentAmount());
		}
	}
}