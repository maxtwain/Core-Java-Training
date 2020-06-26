/*
Write an application that reads two integers, determines whether the first is a multiple of 
the second and prints the result. [Hint: Use the remainder operator.]
*/

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int num0 = input.nextInt();
		System.out.print("Enter second integer: ");
		int num1 = input.nextInt();
		
		if(num1 % num0 == 0) {
			System.out.printf("%d is a multiple of %d%n",  num0, num1);
		}
		else {
			System.out.printf("%d is not a multiple of %d%n",  num0, num1);
		}
	}
}