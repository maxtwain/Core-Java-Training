/*
 * Write an application that calculates 
 * the product of the odd integers from 
 * 1 to 15.
 */

public class Product{
	public static void main(String[] args) {
		int product = 1;
		for(int i = 1; i < 16; i += 2) {
			product *= i;
		}
		System.out.printf("product = %d%n", product);
	}
}