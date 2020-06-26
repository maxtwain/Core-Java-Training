/*
 * Write a method isMultiple that determines, for a pair 
 * of integers, whether the second integer is a multiple 
 * of the first.  The method should take two integer 
 * arguments and return true if the second is a multiple 
 * of the first and false otherwise.  Incorporate this 
 * method into an application that inputs a series of 
 * pairs of integers (one pair at a time) and determines 
 * whether the second value in each pair is a multiple 
 * of the first.
 * 
 */
import java.util.Scanner;

public class Multiples {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter dividend integer: ");
		int dividend = input.nextInt();
		System.out.print("Enter divisor integer: ");
		int divisor = input.nextInt();
		
		System.out.printf("%d %s a multiple of %d", divisor, 
				isMultiple(dividend, divisor) ? "is" : "is not", dividend);
	}
	
	public static boolean isMultiple(int num0, int num1) {
		return num0 % num1 == 0;
	}
}