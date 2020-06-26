/*
 * Write an application that displays the 
 * following patterns separately, one 
 * below the other.  Use for loops to 
 * generate the patterns.  All asterisks 
 * should be printed by a single statement 
 * of the form Ssytem.out.print('*'); 
 * which causes the asterisks to print 
 * side by side.  A statement of the 
 * form Ssytem.out.println(); can be 
 * used to move to the next line.  A 
 * statement of the form System.out.print(' '); 
 * can be used to display as space for 
 * the last two patterns.  There should 
 * be no other output statements in the 
 * program.  [Hint: The last two patterns 
 * require that each line begin with an 
 * appropriate number of blank spaces.]
 */

public class Triangle{
	public static void main(String[] args) {
		// A)
		
		for(int row = 0; row < 10; ++row) {
			for(int col = 0; col < 10; ++col) {
				if(row - col >= 0) {
					System.out.print('*');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// B)
		
		for(int row = 0; row < 10; ++row) {
			for(int col = 0; col < 10; ++col) {
				if(row + col < 10) {
					System.out.print('*');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// C)
		
		for(int row = 0; row < 10; ++row) {
			for(int col = 0; col < 10; ++col) {
				if(row - col <= 0) {
					System.out.print('*');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// D)
		
		for(int row = 0; row < 10; ++row) {
			for(int col = 0; col < 10; ++col) {
				if(row + col >= 9) {
					System.out.print('*');
				}
				else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}