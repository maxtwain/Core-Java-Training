/*
 * Modify Exercise 5.15 to combine your code 
 * from the four separate triangles of asterisks 
 * such that all four patterns print side by side.
 */

public class Triangle{
	public static void main(String[] args) {
		
		for(int row = 0; row < 10; ++row) {
			for(int col = 0; col < 49; ++col) {
				// A)
				if(col < 10) {
					if(row - col >= 0) {
						System.out.print('*');
					}
					else {
						System.out.print(' ');
					}
				}
				
				// B)
				if(col >= 10 && col < 13) {
					System.out.print(' ');
				}
				if(col >= 13 && col < 23) {
					if(row + col < 23) {
						System.out.print('*');
					}
					else {
						System.out.print(' ');
					}
				}
				
				// C)
				if(col >= 23 && col < 26) {
					System.out.print(' ');
				}
				if(col >= 26 && col < 36) {
					if(row - col <= -26) {
						System.out.print('*');
					}
					else {
						System.out.print(' ');
					}
				}
				
				// D)
				if(col >= 36 && col < 39) {
					System.out.print(' ');
				}
				if(col >= 39) {
					if(row + col >= 48) {
						System.out.print('*');
					}
					else {
						System.out.print(' ');
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}