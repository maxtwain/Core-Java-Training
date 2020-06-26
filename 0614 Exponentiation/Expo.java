/*
 * Write a method integerPower(base, exponent) that 
 * returns the value of base^exponent.  For example, 
 * integerPower(3, 4) calculates 3^4.  Assume that 
 * exponent is a positive nonzero integer and that 
 * base is an integer.  Use a for or while statement 
 * to control the calculation.  Do not use any Math 
 * class methods.  Incorporate this method into an 
 * application that reads integer values for base 
 * and exponent and performs the calculation with 
 * the integerPower method.
 * 
 */
import java.util.Scanner;

public class Expo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a base: ");
		int base = input.nextInt();
		System.out.print("Enter an exponent: ");
		int exp = input.nextInt();
		System.out.printf("%d^%d = %d%n", base, exp, integerPower(base, exp));
	}
	
	public static int integerPower(int base, int exponent) {
		int ret = base;
		while(exponent > 1) {
			ret *= base;
			--exponent;
		}
		return ret;
	}
}