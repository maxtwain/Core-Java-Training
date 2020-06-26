
/*
 * Modify the payroll system of Figs. 10.4 - 10.9 to include private instance variable birthDate in class Employee.  Use class Date of Fig. 8.7 to represent an employee's birthday.  Add get methods to class Date.  Assume that payroll is processed once per month.  Create an array of Employee variables to store references to the various employee objects.  In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person's payroll amount if the current month is the one in which the Employee's birthday occurs.
 */

public class PayrollSystemTest {
	public static void main(String[] args) {

		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", 5000, .04, 300);

		java.security.SecureRandom input = new java.security.SecureRandom();
		int currentMonth = input.nextInt(12) + 1;
		Employee[] employees = new Employee[4];

		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;

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