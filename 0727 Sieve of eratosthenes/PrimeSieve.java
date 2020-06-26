/*
 * A prime number is any integer greater than 1 that's evenly divisible only by itself and 1.  The Sieve of Eratosthenes is a method of finding prime numbers.  It operates as follows:
 * 
 * A) Create a primitive type boolean array with all elements initialized to true.  Array elements with prime indices will remain true.  All other array elements will eventually be set to false.
 * 
 * B) Starting with array index 2, determine whether a given element is true.  If so, loop through the remainder of the array and set false every element whose index is a multiple of the index for the element with the value true.  Then continue the process with the next element with value true.  For array index 2, all elements beyond element 2 in the array that have indices which are multiples of 2 (indices 4, 6, 8, 10, ect.) will be set to false; for the array index 3, all elements beyond element 3 in the array that have indices which are multiples of 3 (indices 6, 9, 12, 15, ect.) will be set to false; and so on.
 * 
 * When this process completes, the array elements that are still true indicate that the index is a prime number.  These indices can be displayed.  Write an application that uses an array of 1,000 elements to determine and display the prime numbers between 2 and 999.  Ignore elements 0 an 1.
 */
import java.util.Arrays;

public class PrimeSieve{
	public static final int SIZE = 1000;
	
	public static void main(String[] args) {
		boolean[] range = new boolean[SIZE];
		Arrays.fill(range, true);
		range[0] = false;
		range[1] = false;
		
		System.out.println("Prime List");
		for(int num = 2; num < SIZE; ++num) {
			if (range[num] == true) {
				System.out.printf("%5d", num);
				for(int mag = 2; num * mag < SIZE; ++mag) {
					range[num*mag] = false;
				}
			}
		}
	}
}