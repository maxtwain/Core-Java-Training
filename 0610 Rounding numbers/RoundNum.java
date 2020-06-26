/*
 * To round numbers to specific decimal 
 * places, use a statement like
 * 
 * double y = Math.floor(x * 10 + 0.5) / 10;
 * 
 * which rounds x to the tenths position (the 
 * first position to the right of the decimal point), or
 * 
 * double y = Math.floor(x * 100 + 0.5) / 100;
 * 
 * which rounds x to the hundredths position 
 * (the second position to the right of the 
 * decimal point).  Write an application that 
 * defines four methods for rounding a number 
 * x in various ways:
 * 
 * A) roundToInteger(number)
 * B) roundToTenths(number)
 * C) roundToHundredths(number)
 * D) roundToThousandths(number)
 */

public class RoundNum{
	public static void main(String[] args) {
		
		System.out.printf("%d%n", roundToInteger(-3.3));
		System.out.printf("%d%n", roundToInteger(-3.6));
		
		System.out.printf("%f%n", roundToTenths(-4.567));
		System.out.printf("%f%n", roundToTenths(-4.2319));
		
		System.out.printf("%f%n", roundToHundredths(-4.6978));
		System.out.printf("%f%n", roundToHundredths(-4.2186));
		
		System.out.printf("%f%n", roundToThousandths(-4.93284));
		System.out.printf("%f%n", roundToThousandths(-4.32817));
		
	}
	
	public static int roundToInteger(double number) {
		return (int)Math.floor(number + 0.5);
	}
	
	public static double roundToTenths(double number) {
		return Math.floor(number * 10 + 0.5) / 10;
	}
	
	public static double roundToHundredths(double number) {
		return Math.floor(number * 100 + 0.5) / 100;
	}
	
	public static double roundToThousandths(double number) {
		return Math.floor(number * 1000 + 0.5) / 1000;
	}
}