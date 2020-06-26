/*
 * A palindrome is a sequence of characters that reads 
 * the same backward as forward.  For example, each of 
 * the following five digit integers is a palindrome: 
 * 12321, 55555, 45554, and 11611.  Write an 
 * application that reads in a five digit integer and 
 * determines whether it's a palindrome.  If the 
 * number is not five digits long, display an error 
 * message and allow the user to enter a new value.
 */
import java.util.Scanner;

public class IsPal{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a five digit number: ");
		int num = input.nextInt();
		while (num < 10000 || num > 99999) {
			System.out.print("Invalid entry.  Enter a five digit number: ");
			num = input.nextInt();
		}
		
		int numCopy = num;
		boolean affirm = true;
		if(num / 10000 != num % 10) {
			affirm = false;
		}
		num = num % 10000;
		num = num / 10;
		if(num / 100 != num % 10) {
			affirm = false;
		}
		
		if(affirm == true) {
			System.out.printf("%d is a palindrome.", numCopy);
		}
		else {
			System.out.printf("%d is not a palindrome.", numCopy);
		}
	}
}