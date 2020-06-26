/*
 * Write a method that takes an integer value and returns the number with 
 * its digits reversed.  For example, given the number 7631, the method 
 * should return 1367.  Incorporate the method into an application that 
 * reads a value from the user and displays the result.
 */
import java.util.Scanner;

public class Reverse{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		System.out.printf("%d reversed = %d", num, reverse(num));
	}
	
	public static int reverse(int num) {
		int rev = 0;
		int numCopy = num;
		int tens = 0;
		while (numCopy > 0) {
			++tens;
			numCopy /= 10;
		}
		
		--tens;
		for(int low = 0; low <= tens; ++low) {
			int div = (int)Math.pow(10, tens - low);
			int up = (int)Math.pow(10, low);
			rev += num / div * up;
			num %= div;
		}
		return rev;
	}
}