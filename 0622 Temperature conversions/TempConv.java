/*
 * Implement the following integer methods:
 * 
 * A) Method celsius returns the Celsius equivalent of a Fahrenheit temperature, 
 * using the calculation
 * 
 * celsius = 5.0 / 9.0 * (fahrenheit - 32);
 * 
 * B) Method fahrenheit returns the Fahrenheit equivalent of a Celsius temperature, 
 * using the calculation
 * 
 * fahrenheit = 9.0 / 5.0 * celsius + 32;
 * 
 * C Use the methods from parts (a) and (b) to write an application that 
 * enables the user either to enter a Fahrenheit temperature and display 
 * the Celsius equivalent or to enter a Celsius temperature and display the 
 * Fahrenheit equivalent.
 * 
 */
import java.util.Scanner;

public class TempConv {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 1 to convert to fahrenheit or 2 to convert to Celcius: ");
		int fc = input.nextInt();
		System.out.print("Enter temp: ");
		double temp = input.nextDouble();
		if (fc == 1) {
			temp = toFah(temp);
		}
		else {
			temp = toCel(temp);
		}
		
		System.out.printf("Converted temp = %f%n", temp);
	}
	
	public static double toFah(double cel) {
		return 9.0 / 5.0 * cel + 32;
	}
	
	public static double toCel(double fah) {
		return 5.0 / 9.0 * (fah - 32);
	}
	
}