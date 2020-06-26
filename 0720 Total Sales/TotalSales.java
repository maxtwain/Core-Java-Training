/*
 * Use a two dimensional array to solve the following problem: A company has four salespeople (1 to 4) who sell five different products (1 to 5).  Once per day, each salesperson passes in a slip for each type of product sold.  Each slip contains the following:
 * 
 * A) The salesperson number
 * B) The product number
 * C) The total dollar value of that product sold that day
 * 
 * Thus, each salesperson passes in between 0 and 5 sales slips per day.  Assume that the information from all the slips for the last month is available.  Write an application that will read all this information for last month's sales and summarize the total sales by salesperson and by product.  All totals should be stored in the two dimensional array sales.  After processing all the information for the last month, display the results in tabular format, with each column representing a salesperson and each row representing a particular product.  Cross total each row to get the total sales of each product for the last month.  Cross total each column to get the total sales by salesperson for the last month.  Your output should include these cross totals to the right of the totaled rows and to the bottom of the totaled columns.
 */
import java.security.SecureRandom;

public class TotalSales{
	public static final SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {
		
		int[][] sales = new int[6][4];
		for(int row = 0; row < sales.length - 1; ++row) {
			for(int col = 0; col < sales[row].length; ++col) {
				sales[row][col] = rand.nextInt(100);
			}
		}
		int sum;
		for (int col = 0; col < 4; ++col) {
			sum = 0;
			for (int row = 0; row < 5; ++row) {
				sum += sales[row][col];
			}
			sales[5][col] = sum;
		}
		
		System.out.printf("%5s", "");
		for (int person = 0; person < 4; ++person) {
			System.out.printf("%5d", person + 1);
		}
		System.out.printf("%8s", "Total");
		System.out.println();
		
		int prodSum;
		for (int product = 0; product < 6; ++product) {
			if (product < 5) {
				System.out.printf("%5d", product + 1);
			}
			else {
				System.out.printf("%5s", "Sum");
			}
			prodSum = 0;
			for (int person = 0; person < 4; ++person) {
				System.out.printf("%5d", sales[product][person]);
				prodSum += sales[product][person];
			}
			System.out.printf("%8d%n", prodSum);
		}
	}
}