/*
 * Write an application that uses only the output statements
 * 
 * System.out.print("* ");
 * System.out.print(" ");
 * System.out.println();
 * 
 * to display the checkerboard pattern that follows.  
 * A System.out.println method call with no arguments 
 * cases the program to output a single newline 
 * character.  [Hint: Iteration statements are required.]
 * 
 * * * * * * * * *
 *  * * * * * * * *
 * * * * * * * * *
 *  * * * * * * * *
 * * * * * * * * *
 *  * * * * * * * *
 * * * * * * * * *
 *  * * * * * * * *
 */

public class Checkerboard{
	public static void main(String[] args) {
		
		for(int row = 0; row < 8; ++row) {
			if (row % 2 == 1) {
				System.out.print(" ");
			}
			for(int col = 0; col < 8; ++col) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}