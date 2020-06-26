/*
 * Develop a Java application that determines the 
 * gross pay for each of three employees.  The 
 * company pays straight time for the first 40 hours 
 * worked by each employee and time and a half for 
 * all hours worked in excess of 40.  You're given 
 * a list of the employees, their number of hours 
 * worked last week and their hourly rates.  Your 
 * program should input this information for each 
 * employee, then determine and display the 
 * employee's gross pay.  Use class Scanner to 
 * input the data.
 */

public class RecordTest{
	public static void main(String[] arg) {
		Record emp0 = new Record(10, 10);
		Record emp1 = new Record(50, 10);
		Record emp2 = new Record(40, 10);
		
		System.out.printf("emp0 gross: %.2f%n", emp0.getGross());
		System.out.printf("emp1 gross: %.2f%n", emp1.getGross());
		System.out.printf("emp2 gross: %.2f%n", emp2.getGross());
	}
}