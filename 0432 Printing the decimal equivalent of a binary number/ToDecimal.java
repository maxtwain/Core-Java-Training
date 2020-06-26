/*
 * Write an application that inputs an integer 
 * containing only 0's and 1's and prints its 
 * decimal equivalent.
 */
import java.util.Scanner;

public class ToDecimal{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary number: ");
		int binary = input.nextInt();
		
		int decimal = 0;
		for(int mult = 1; binary > 0; binary /= 10) {
			decimal += binary % 10 * mult;
			mult *= 2;
		}
		System.out.printf("Decimal = %d%n", decimal);
	}
}