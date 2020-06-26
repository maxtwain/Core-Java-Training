/*
 * Write an application that prints the following 
 * diamond shape.  You may use output statements 
 * that print a single asterisk, a single space, 
 * or a single newline character.  Maximize your 
 * use of iteration, and minimize the number of 
 * output statements.
 */

public class Diamond {
	public static void main(String[] args) {
		for(int row = 0; row < 9; ++row) {
			for(int col = 0; col < 9; ++col) {
				if(row <= 4 && ((row + col >= 4) && (col - row <= 4)) ||
					row > 4 && ((row - col <= 4) && (row + col <= 12))) {
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