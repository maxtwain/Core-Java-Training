/*
 * Modify the application you wrote in Exercise 
 * 5.24 to read an odd number in the range 1 to 
 * 19 to specify the number of rows in the 
 * diamond.  Your program should then display a 
 * diamond of the appropriate size.
 */
import java.util.Scanner;

public class Diamond {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter diamond rows: ");
		int dRows = input.nextInt();
		
		for(int row = 0; row < dRows; ++row) {
			for(int col = 0; col < dRows; ++col) {
				if(row <= dRows / 2 && ((row + col >= dRows / 2) && (col - row <= dRows / 2)) ||
					row > dRows / 2 && ((row - col <= dRows / 2) && (row + col <= dRows / 2 * 3))) {
					System.out.print('*');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
}