/*
 * Write an application that calculates the product of a series of integers that are passed to method product using a variable length argument list.  Test your method with several calls, each with a different number of arguments.
 */
import java.security.SecureRandom;

public class Product{
	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		
		int num0 = 1 + rand.nextInt(9);
		int num1 = 1 + rand.nextInt(9);
		int num2 = 1 + rand.nextInt(9);
		int num3 = 1 + rand.nextInt(9);
		int num4 = 1 + rand.nextInt(9);
		int num5 = 1 + rand.nextInt(9);
		
		System.out.printf("Product of 2 numbers: %d%n", 
				product(num0, num1));
		System.out.printf("Product of 3 numbers: %d%n", 
				product(num0, num1, num2));
		System.out.printf("Product of 4 numbers: %d%n", 
				product(num0, num1, num2, num3));
		System.out.printf("Product of 5 numbers: %d%n", 
				product(num0, num1, num2, num3, num4));
		System.out.printf("Product of 6 numbers: %d%n", 
				product(num0, num1, num2, num3, num4, num5));
	}
	
	public static int product(int... numbers) {
		int ret = 1;
		for (int num : numbers) {
			ret *= num;
		}
		return ret;
	}
}