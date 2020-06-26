/*
 * Perform the following tasks for an array called fractions:
 * A) Declare a constant ARRAY_SIZE that's initialized to 10.
 * B) Declare an array with ARRAY_SIZE elements of type double, and initialize the elements to 0.
 * C) Refer to array element 4.
 * D) Assign the value 1.667 to array element 9.
 * E) Assign the value 3.333 to array element 6.
 * F) Sum all the elements of the array, using a for statement.  Declare the integer variable x as a control variable for the loop.
 */

public class Source{
	private static final int ARRAY_SIZE = 10;
	
	public static void main(String[] args) {
		double[] arr = new double[ARRAY_SIZE];
		
		double refer = arr[4];
		
		arr[9] = 1.667;
		
		arr[6] = 3.333;
		
		int sum = 0;
		for (int x = 0; x < arr.length; ++x) {
			sum += arr[x];
		}
	}
}