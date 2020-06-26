/*
 * Identify and correct the error in each of the following code segments.  Assume that all
 * variables have been properly declared and initialized.
 */

public class Source{
	public static void main(String[] args) {
		
		// A)
		int c = 0;
		int product = 0;
		
		while (c <= 5) {
			product *= c;
			++c;
		}
		
		// B)
		
		int gender = 0;
		if (gender == 1) {
			System.out.println("Woman");
		}
		else {
			System.out.println("Man");
		}
		
	}
}