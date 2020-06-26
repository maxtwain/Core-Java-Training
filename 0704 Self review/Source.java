/*
 * Perform the following tasks for an array called table:
 * A) Declare and create the array as an integer array that has three rows and three columns.  Assume that the constant ARRAY_SIZE has been declared to be 3.
 * B) How many elements does the array contain?
 * C) Use a for statement to initialized each element of the array to the sum of its indices.  Assume that the integer variables x and y are declared as control variables.
 * 
 */

public class Source{
	public static final int ARRAY_SIZE = 3;
	
	public static void main(String[] args) {
		int[][] table = new int[ARRAY_SIZE][ARRAY_SIZE];
		// the array contains nine elements.
		for(int x = 0; x < ARRAY_SIZE; ++x) {
			for(int y = 0; y < ARRAY_SIZE; ++y) {
				table[x][y] = x + y;
			}
		}
	}
}