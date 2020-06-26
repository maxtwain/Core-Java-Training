/*
 * A parking garage charges a $2 minimum fee to park 
 * up to three hours.  The garage charges an 
 * additional $0.50 per hour for each hour or part 
 * thereof in excess of three hours.  The maximum 
 * charge for any given 24 hour period is $10.00.  
 * Assume that no car parks for longer than 24 hours 
 * at a time.  
 * 
 * Write an application that calculates 
 * and displays the parking charges for each customer 
 * who parked in the garage yesterday.  You should 
 * enter the hours parked for each customer.  The 
 * program should display the charge for the current 
 * customer and should calculate and display the 
 * running total of yesterday's receipts.  It should 
 * use the method calculateCharges to determine the 
 * charge for each customer.
 */
import java.util.Scanner;

public class Parking{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double totCost = 0.0;
		System.out.print("Enter hours parked or -1 to quit: ");
		double time = input.nextDouble();
		while (time != -1) {
			double cost = calculateCharges(time);
			System.out.printf("Parking cost = $%.2f%n", cost);
			totCost += cost;
			
			System.out.print("Enter hours parked or -1 to quit: ");
			time = input.nextDouble();
		}
		System.out.printf("Total parking cost = $%.2f%n", totCost);
	}
	public static double calculateCharges(double time) {
		double cost = 2.0;
		if (time > 3.0) {
			cost += time * 0.5;
		}
		if (cost > 10.0) {
			cost = 10.0;
		}
		return cost;
	}
}