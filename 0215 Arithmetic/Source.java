// Write an application that asks the user to enter two integers, obtains them from the user and 
// prints their sum, product, difference and quotient.

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int num0 = input.nextInt();
		System.out.print("Enter second integer: ");
		int num1 = input.nextInt();
		
		System.out.printf("sum = %d%nproduct = %d%nquotient = %d%n", 
				(num0 + num1), (num0 * num1), (num0 / num1));
		
	}
}