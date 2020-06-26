/*
 * A) Write an application that reads a 
 * nonnegative integer and computes and 
 * prints its factorial.
 * 
 * B) Write an application that 
 * estimates the value of the 
 * mathematical constant e by using the 
 * following formula.  Allow the user to 
 * enter the number of terms to calculate.
 * 
 * C) Write an application that computes 
 * the value of e^x by using the following 
 * formula.  Allow the user to enter the 
 * number of terms to calculate.
 * 
 */
import java.util.Scanner;

public class MathStuff{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter terms to print e: ");
		int terms = input.nextInt();
		System.out.printf("e = %f%n", e1(terms));
		
		System.out.print("Enter an exponent to find e^x: ");
		int exp = input.nextInt();
		System.out.print("Enter number of terms: ");
		terms = input.nextInt();
		System.out.printf("e^%d = %f%n", exp, ex(exp, terms));
		
	}
	
	public static int factorial(int num) {
		int fact = 1;
		while(num > 1) {
			fact *= num;
			--num;
		}
		return fact;
	}
	
	public static double e1(int terms) {
		double e = 1.0;
		while(terms > 0) {
			e += 1.0 / factorial(terms);
			--terms;
		}
		return e;
	}
	
	public static int power(int num, int exp) {
		int ret = num;
		while(exp > 1) {
			ret *= num;
			--exp;
		}
		return ret;
	}
	
	public static double ex(int num, int terms) {
		double e = 1.0;
		while(terms > 0) {
			e += (double)power(num, terms) / factorial(terms);
			--terms;
		}
		return e;
	}
}