/*
 * Declare method sphereVolume to calculate and return 
 * the volume of the sphere.  Use the following 
 * statement to calculate the volume:
 * 
 * double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3)
 * 
 * Write a Java application that prompts the user for 
 * the double radius of a sphere, calls shpereVolume to 
 * calculate the volume and displays the result.
 * 
 */
import java.util.Scanner;

public class Sphere {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = input.nextDouble();
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		System.out.printf("volume = %f%n", volume);
	}
}