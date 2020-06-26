/*
 * The Fibonacci series
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * begins with the terms 0 and 1 and has the property that each succeeding term is the sum of the two preceding terms.
 * 
 * A) Write a method Fibonacci(n) that calculates the nth Fibonacci number.  Incorporate this method into an application that enables the user to enter the value of n.
 * 
 * B) Determine the largest Fibonacci number that can be displayed on your system.
 * 
 * C) Modify the application you wrote in part (a) to use double instead of int to calculate and return Fibonacci numbers, and use this modified application to repeat part (b).
 * 
 * 
 * 
 * It is odd that double is asked for rather than long in part C.  As for part B, I am going to assume that it means the largest int fib and not the largest BigInt.
 */
import java.util.Scanner;

public class Fibonacci{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter value of n: ");
		int n = input.nextInt();
		System.out.printf("Fib(n) = %d%n", fib(n));
		
		System.out.printf("Max fib = %,d%n", lastIntFib());
		
		System.out.print("Enter value of n: ");
		n = input.nextInt();
		System.out.printf("Fib(n) = %f%n", doubleFib(n));
	}
	
	public static int fib(int n) {
		int fib0 = 0;
		int fib1 = 1;
		if (n == 1) {
			return fib0;
		}
		n -= 2;
		for(; n > 0; --n) {
			fib1 = fib1 + fib0;
			fib0 = fib1 - fib0;
		}
		return fib1;
	}
	
	public static int lastIntFib() {
		int fib0 = 0;
		int fib1 = 1;
		
		while(fib1 >= fib0) {
			fib1 = fib1 + fib0;
			fib0 = fib1 - fib0;
		}
		return fib0;
	}
	
	public static double doubleFib(int n) {
		double fib0 = 0;
		double fib1 = 1;
		if (n == 1) {
			return fib0;
		}
		n -= 2;
		for(; n > 0; --n) {
			fib1 = fib1 + fib0;
			fib0 = fib1 - fib0;
		}
		return fib1;
	}
}