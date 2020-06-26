/*
 * Math.floor can be used to round values to the nearest integer.
 * 
 * double y = Math.floor(x + 0.5);
 * 
 * will round the number x to the nearest integer 
 * and assign the result to y.  Write an application 
 * that reads double values and uses the preceding 
 * statement to round each of the numbers to the 
 * nearest integer.  For each number processed, 
 * display both the original number and the rounded 
 * number.
 * 
 */
import java.util.Scanner;

public class RoundNum{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a float to round or -1 to exit: ");
		double f = input.nextDouble();
		while (f != -1) {
			System.out.printf("original = %f%nrounded = %f%n", f,
					Math.floor(f + 0.5));
			
			System.out.print("Enter a float to round or -1 to exit: ");
			f = input.nextDouble();
		}
	}
}