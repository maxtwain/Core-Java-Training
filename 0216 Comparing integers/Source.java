// Write an application that asks the user to enter two integers, obtains them from the user and 
// displays the larger number followed by the words "is larger".  If the numbers are equal print 
// the message "These numbers are equal".

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int num0 = input.nextInt();
		System.out.print("Enter second integer: ");
		int num1 = input.nextInt();
		
		if(num0 == num1) {
			System.out.println("These numbers are equal");
		}
		else {
			if(num0 < num1) {
				num0 = num1;
			}
			System.out.printf("%d is larger%n", num0);
		}
	}
}