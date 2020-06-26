/*
 * Write a method isEven that uses the remainder operator 
 * (%) to determine whether an integer is even.  The 
 * method should take an integer argument and return 
 * true if the integer is even and false otherwise.  
 * Incorporate this method into an application that 
 * inputs a sequence of integers and determines whether 
 * each is even or odd.
 * 
 */
import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an int or -1 to quit: ");
		int num = input.nextInt();
		while (num != -1) {
			System.out.printf("%d is %s%n", num, isEven(num) ? "even." : "odd.");
			
			System.out.print("Enter an int or -1 to quit: ");
			num = input.nextInt();
		}
	}
	
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
}