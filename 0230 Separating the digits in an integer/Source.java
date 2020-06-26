/*
Write an application that inputs one number consisting of five digits from the user, 
separates the number into its individual digits and prints the digits separated from 
one another by three spaces each.
*/

import java.util.Scanner;

public class Source {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a five digit integer: ");
		int num = input.nextInt();
		
		System.out.printf("%d   ", num / 10000);
		num %= 10000;
		System.out.printf("%d   ", num / 1000);
		num %= 1000;
		System.out.printf("%d   ", num / 100);
		num %= 100;
		System.out.printf("%d   ", num / 10);
		num %= 10;
		System.out.printf("%d   ", num);
	}
}