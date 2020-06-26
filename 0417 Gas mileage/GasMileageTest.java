/*
 * Develop a Java application that will input the 
 * miles driven and gallons used (both as integers) 
 * for each trip.  The program should calculate and 
 * display the miles per gallon obtained for each 
 * trip and print the combines miles per gallon 
 * obtained for all trips up to this point.  All 
 * averaging calculations should produce floating 
 * point results.  Use class Scanner and sentinel 
 * controlled iteration to obtain the data from 
 * the user.
 */
import java.util.Scanner;

public class GasMileageTest{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		GasMileage driver0 = new GasMileage(0, 0);
		System.out.print("Gas Mileage or -1 to quit: ");
		int miles;
		int gallons;
		while((miles = input.nextInt()) != -1) {
			driver0.setMiles(miles);
			System.out.print("Gallons used: ");
			gallons = input.nextInt();
			driver0.setGallons(gallons);
			System.out.printf("Trip MPG: %.2f%n", driver0.getCurMPG());
			System.out.print("Gas Mileage or -1 to quit: ");
		}
		
		System.out.printf("Total MPG: %.2f%n", driver0.getTotMPG());
	}
}