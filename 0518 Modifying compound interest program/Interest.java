/*
 * Modify the application if Fig 5.6 to use 
 * only integers to calculate the compound 
 * interest.
 */

public class Interest {
	public static void main(String[] args) {
		int principal = 100000;
		int rate = 5;
		
		System.out.printf("%s%20s%n", "Year", "Amount on deposit");
		for(int year = 1; year <= 10; ++year) {
			int amount = (int)(principal * Math.pow(1 + (double)rate / 100, year));
			// int amount = principal * power(100 + rate, year) / power(100, year);
			System.out.printf("%4d%,20.2f%n", year, (double)amount / 100);
		}
	}
	
	// this overflows, so it doesn't work
	public static int power(int base, int exp) {
		int ret = base;
		while(exp > 1) {
			ret *= base;
			--exp;
		}
		return ret;
	}
}