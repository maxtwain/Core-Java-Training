/*
 * Write method distance to calculate the distance between two points (x1, y1) and (x2, y2).  All number and return values should be of type double.  Incorporate this method into an application that enables the user to enter the coordinates of the points.
 * 
 */
import java.util.Scanner;

public class Distance {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("x1: ");
		double x1 = input.nextDouble();
		System.out.print("y1: ");
		double y1 = input.nextDouble();
		System.out.print("x2: ");
		double x2 = input.nextDouble();
		System.out.print("y2: ");
		double y2 = input.nextDouble();
		
		System.out.printf("Distance = %f%n", distance(x1, y1, x2, y2));
	}
	
	// distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
	public static double distance(double x1, double y1, double x2, double y2) {
		double side0 = x2 - x1;
		double side1 = y2 - y1;
		return Math.sqrt(Math.pow(side0, 2) + Math.pow(side1, 2));
	}
}