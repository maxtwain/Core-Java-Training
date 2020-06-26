/*
 * Write methods that accomplish each of the following tasks:
 * 
 * A) Calculate the integer part of the quotient when integer a is divided by integer b.
 * 
 * B) Calculate the integer remainder when integer a is divided by integer b.
 * 
 * C) Use the methods developed in parts (a) and (b) to write a method 
 * displayDigits that receives an integer between 1 and 99999 and displays 
 * it as a sequence of digits, separating each pair of digits by two spaces.  
 * For example, the integer 4562 should appear as 4  5  6  2.  Incorporate the 
 * methods into an application that inputs an integer and calls displayDigtis by 
 * passing the method the integer enter.  Display the results.
 * 
 */

public class Separate {
	public static void main(String[] args) {
		displayDigits(12345);
	}
	
	public static int div(int a, int b) {
		return a / b;
	}
	
	public static int mod(int a, int b) {
		return a % b;
	}
	
	public static void displayDigits(int num) {
		int numCopy = num;
		int tens = 0;
		while (numCopy > 0) {
			++tens;
			numCopy = div(numCopy, 10);
		}
		
		--tens;
		while(tens >= 0) {
			System.out.printf("%d  ", div(num, (int)Math.pow(10, tens)));
			num = mod(num, (int)Math.pow(10, tens));
			--tens;
		}
	}
}