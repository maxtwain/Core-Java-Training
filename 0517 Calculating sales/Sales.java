/*
 * An online retailer sells five products 
 * whose retail prices are as follows: 
 * Product 1, $2.98; product 2, $4.50; 
 * product 3, $9.98; product 4, $4.49; 
 * and product 5, $6.87.  Write an 
 * application that reads a series of 
 * pairs of numbers as follows:
 * 
 * A) product number
 * B) Quantity sold
 * 
 * Your program should use a switch 
 * statement to determine the retail 
 * price for each product.  It should 
 * calculate and display the total 
 * retail value of all products sold.  
 * Use a sentinel controlled loop to 
 * determine when the program should 
 * stop looping and display the final 
 * results.
 */

import java.util.Scanner;

public class Sales{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int prodNum = 0;
		int quantity = 0;
		double totSales = 0.0;
		System.out.print("Enter new product number or -1 to quit: ");
		prodNum = input.nextInt();
		while(prodNum != -1) {
			System.out.print("Enter quantity sold: ");
			quantity = input.nextInt();
			switch(prodNum) {
			case 1:
				totSales += 2.98 * quantity;
				break;
			case 2:
				totSales += 4.50 * quantity;
				break;
			case 3:
				totSales += 9.98 * quantity;
				break;
			case 4:
				totSales += 4.49 * quantity;
				break;
			case 5:
				totSales += 6.87 * quantity;
				break;
			case -1:
				break;
			default:
				System.out.println("Invalid entry.");
			}
			System.out.print("Enter new product number or -1 to quit: ");
			prodNum = input.nextInt();
		}
		System.out.printf("Retail value of all products sold = $%.2f%n", totSales);
	}
}