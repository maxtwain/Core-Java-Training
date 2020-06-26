/*
 * The greatest common divisor of two integers is the largest 
 * integer that evenly divides each of the two numbers.  
 * Write a method gcd that returns the greatest common 
 * divisor of two integers.  Incorporate the method into an 
 * application that reads two values from the user and 
 * displays the result.
 */
import java.util.Scanner;

public class Divisor{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		int num0 = input.nextInt();
		System.out.print("Enter second number: ");
		int num1 = input.nextInt();
		
		System.out.printf("GCD = %d%n", gcd(num0, num1));
		
	}
	
	public static int gcd(int num0, int num1) {
		
		int max = Math.max(num0, num1);
		int min = Math.min(num0, num1);
		if (max % min == 0) {
			return min;
		}
		
		for(min /= 2; min > 0; --min) {
			if(max % min == 0) {
				return min;
			}
		}
		return 1;
	}
}