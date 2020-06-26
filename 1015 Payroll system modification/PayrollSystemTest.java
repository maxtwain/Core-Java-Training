
/*
 * Modify the payroll system of Figs. 10.4 - 10.9 to include an additional Employee subclass PieceWorker that represents an employee whose pay is based on the number of pieces of merchandise produced.  Class PieceWorker should contain private instance variables wage (to store the employee's wage per piece) and pieces (to store the number of pieces produced).  Provide a concrete implementation of method earnings in class PieceWorker that calculates the employee's earnings by multiplying the number of pieces produced by the wage per piece.  Create an array of Employee variables to store references to objects of each concrete class in the new Employee hierarchy.  For each Employee, display its String representation and earnings.
 */

public class PayrollSystemTest {
	public static void main(String[] args) {

		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", 5000, .04, 300);
		PieceWorker pieceWorker = new PieceWorker("Joe", "Mann", "123-45-6789", 3.33, 200);

		java.security.SecureRandom input = new java.security.SecureRandom();
		int currentMonth = input.nextInt(12) + 1;
		Employee[] employees = new Employee[5];

		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = pieceWorker;

		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString
			if (currentEmployee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			if (currentEmployee.getBirth().getMonth() == currentMonth) {
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings() + 100);
			}
			else {
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
			}
		}
	}
}