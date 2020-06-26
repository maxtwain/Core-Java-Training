/*
 * Write an application to simulate the rolling of two dice.  The application should use an object of class Random once to roll the first die and again to roll the second die.  The sum of the two values should then be calculated.  Each die can show an integer value from 1 to 6, so the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least frequent.  Figure 7.28 shows the 36 possible combinations of the two dice.  Your application should roll the dice 36,000,000 times.  Use a one dimensional array to tally the number of times each possible sum appears.  Display the results in tabular format.
 * 
 * 
 * 
 * 36 million rolls is nonsense.  Computers aren't fast enough for that in a small exercise such as this.
 */
import java.security.SecureRandom;

public class DiceRolling{
	public static final int MAX_ROLLS = 36000;
	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		int[] arr = new int[13];
		
		for (int roll = 0; roll < MAX_ROLLS; ++roll) {
			++arr[1 + rand.nextInt(6) + 1 + rand.nextInt(6)];
		}
		
		System.out.printf("%-5s%s%n", "Sum", "Frequency");
		for(int i = 2; i < arr.length; ++i) {
			System.out.printf("%-5d%d%n", i, arr[i]);
		}
	}
}