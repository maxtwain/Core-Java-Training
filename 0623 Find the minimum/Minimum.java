/*
 * Write a method minimum3 that returns the smallest of three floating 
 * point numbers.  use the Math.min method to implement minimum3.  
 * Incorporate the method into an application that reads three values 
 * from the user, determines the smallest value and displays the result.
 * 
 */
import java.util.Scanner;

public class Minimum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first float: ");
		float num0 = input.nextFloat();
		System.out.print("Enter the second float: ");
		float num1 = input.nextFloat();
		System.out.print("Enter the third float: ");
		float num2 = input.nextFloat();
		
		System.out.printf("The smallest = %f%n", minimum3(num0, num1, num2));
	}
	
	public static float minimum3(float num0, float num1, float num2) {
		float min = Math.min(num0, num1);
		return Math.min(min, num2);
	}
}