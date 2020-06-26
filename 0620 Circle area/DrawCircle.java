/*
 * Write an application that prompts the user for the radius 
 * of a circle and uses a method called circleArea to 
 * calculate the area of the circle
 * 
 */
import java.util.Scanner;

public class DrawCircle{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = input.nextDouble();
		System.out.printf("Area = %f%n", circleArea(radius));
	}
	
	public static double circleArea(double radius) {
		return Math.PI * radius * radius;
	}
}