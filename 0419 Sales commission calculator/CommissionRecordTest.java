/*
 * A large company pays its salespeople on a 
 * commission basis.  The salespeople receive $200 
 * per week plus 9% of their gross sales for that 
 * week.  For example, a salesperson who sells 
 * $5,000 worth of merchandise in a week receives 
 * $200 plus 9% of $5,000 or a total of $650. You've 
 * been supplied with a list of the items sold by 
 * each salesperson.  The values of these items are 
 * shown in Fig. 4.33.  Develop a Java application 
 * that inputs one salesperson's items sold for last 
 * week and calculates and displays that 
 * salesperson's earnings.  There's no limit to 
 * the number of items that can be sold.
 * 
 * Item		Value
 * 1		239.99
 * 2		129.75
 * 3		99.95
 * 4		350.89
 */
import java.util.Scanner;

public class CommissionRecordTest{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CommissionRecord emp0 = new CommissionRecord(0);
		
		System.out.print("Enter a new sale or -1 to quit: $");
		double sale;
		while((sale = input.nextDouble()) != -1) {
			emp0.newSale(sale);
			System.out.print("Enter a new sale or -1 to quit: $");
		}
		System.out.printf("Weekly earnings: $%.2f%n", emp0.getEarnings());
	}
}