/*
 * Combine the statements you wrote in Exercise 4.5 into a Java application that
 * calculates and prints the sum of the integers from 1 to 10.  Use a while statement to loop through the
 * calculation and increment statements.  The loop should terminate when the value of x becomes 11.
 */

public class Source{
	public static void main(String[] args) {
		
		int sum = 0;
		System.out.printf("sum is %d%n", sum);
		
		int x = 1;
		while ( x < 11) {
			sum += x++;
		}
		System.out.printf("sum is %d%n", sum);
	}
}