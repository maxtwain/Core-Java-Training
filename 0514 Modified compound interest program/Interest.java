/*
 * Modify the compound interest application 
 * of Fig 5.6 to repeat its steps for 
 * interest rates of 5%, 6%, 7%, 8%, 9%, 
 * and 10%.  use a for loop to vary the 
 * interest rate.
 */

public class Interest {
	public static void main(String[] args) {
		for(int i = 5; i <= 10; ++i) {
			account((double)i / 100);
		}
	}
	
	public static void account(double rate) {
		double principal = 1000.0;
		System.out.printf("%6s%%%4.2f %s%20s%n", "Rate: ", rate, "Year", "Amount on deposit");
		
		for (int year = 1; year < 10; ++year) {
			double amount = principal * Math.pow(1.0 + rate, year);
			System.out.printf("%12s%4d%,20.2f%n", " ", year, amount);
		}
		System.out.println();
	}
}