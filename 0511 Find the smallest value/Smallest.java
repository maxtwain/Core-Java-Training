/*
 * Write an application that finds the 
 * smallest of several integers.  Assume 
 * that the first value read specifies 
 * the number of values to input from 
 * the user.
 */
import java.util.Scanner;

public class Smallest{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an initial value: ");
		int value = input.nextInt();
		int small = value;
		for (int i = value - 1; i > 0; --i) {
			System.out.print("Enter another value: ");
			value = input.nextInt();
			if(small > value) {
				small = value;
			}
		}
		System.out.printf("smallest = %d%n", small);
	}
}