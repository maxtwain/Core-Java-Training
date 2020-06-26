/*
Write an application that inputs from the user the radius of a circle as an integer and prints 
the circle's diameter, circumference, and area using the floating point value for pi.

This exercise is asking to use information not yet introduced, so I am skipping it.
*/

import java.util.Scanner;

public class Source {
	public static void main(String[] args) {
		double PI = 3.14159;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter radius of circle: ");
		int radius = input.nextInt();
		
		System.out.printf("diameter = %lf%ncircumference = %lf%narea = %lf%n",
				2 * (double)radius, 2 * PI * (double)radius, PI * (double)radius * radius);
		
	}
}