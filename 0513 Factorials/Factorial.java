/*
 * Factorials are used frequently in 
 * probability problems.  The factorial 
 * of a positive integer n(written n! 
 * and pronounced "n factorial") is equal 
 * to the product of the positive integers 
 * from 1 to n.  Write an application that 
 * calculates the factorials of 1 through 
 * 20.  Use type long.  Display the 
 * results in tabular format.  What 
 * difficulty might prevent you from 
 * calculating the factorial of 100?
 * 
 */

public class Factorial{
	public static void main(String[] args) {
		for(long i = 1; i < 21; ++i) {
			System.out.printf("%,d\t", factorial(i));
		}
	}
	
	public static long factorial(long num) {
		long fact = 1;
		while(num > 1) {
			fact *= num;
			--num;
		}
		return fact;
	}
}

// 100! would quickly overflow.  long is not 
// large enough to handle such a large number.