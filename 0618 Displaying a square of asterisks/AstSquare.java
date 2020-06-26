/*
 * Write a method squareOfAsterisks that displays a solid square 
 * of asterisks whose side is specified in integer parameter side.  
 * Incorporate this method into an application that reads an integer 
 * value for side from the user and outputs the asterisks with the 
 * squareOfAsterisks method.
 * 
 */
import java.util.Scanner;

public class AstSquare {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter square size: ");
		int size = input.nextInt();
		squareOfAsterisks(size);
	}
	
	public static void squareOfAsterisks(int side) {
		for(int row = 0; row < side; ++row) {
			for(int col = 0; col < side; ++col) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}