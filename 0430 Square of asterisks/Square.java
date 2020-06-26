/*
 * Write and application that prompts the user to 
 * enter the size of the side of a square, then 
 * displays a hollow square of that size made of 
 * asterisks.  Your program should work for 
 * squares of all side lengths between 1 and 20.
 */
import java.util.Scanner;

public class Square{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter square size: ");
		int size = input.nextInt();
		while(size < 1 || size > 20) {
			System.out.print("Invalid entry.  Enter square size: ");
			size = input.nextInt();
		}
		
		for(int top = 0; top < size; ++top) {
			System.out.print("*");
		}
		System.out.println("");
		for(int row = 1; row < size - 1; ++row) {
			for(int col = 0; col < size; ++col) {
				if(col == 0 || col == size - 1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		for(int bot = 0; bot < size && size > 1; ++bot) {
			System.out.print("*");
		}
		System.out.println("");
	}
}