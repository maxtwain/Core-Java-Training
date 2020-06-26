/*
 * Write an application that reads three 
 * nonzero values entered by the user 
 * and determines and prints whether 
 * they could represent the sides of a 
 * triangle.
 */
import java.util.Scanner;

public class IsTriangle{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int temp;
		System.out.print("Enter a length: ");
		int hyp = input.nextInt();
		System.out.print("Enter a length: ");
		int side0 = input.nextInt();
		if(side0 > hyp) {
			temp = hyp;
			hyp = side0;
			side0 = temp;
		}
		System.out.print("Enter a length: ");
		int side1 = input.nextInt();
		if(side1 > hyp) {
			temp = hyp;
			hyp = side1;
			side1 = temp;
		}
		
		if(hyp <= side0 + side1 && hyp > 0 && side0 > 0 && side1 > 0) {
			System.out.println("This set may be a triangle.");
		}
		else {
			System.out.println("This set cannot be a triangle.");
		}
	}
}