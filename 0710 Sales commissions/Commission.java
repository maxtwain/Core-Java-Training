/*
 * Use a one dimensional array to solve the following problem:  A company pays its sales people on a commission basis.  The salespeople receive $200 per week plus 9% of their gross sales for that week.  For example, a salesperson who grosses $5,000 in sales in a week receives $200 plus 9% of $5,000, or a total of $650.  Write an application (using an array of counters) that determines how many of the salespeople earned salaries in each of the following ranges (assume that each salesperson's salary is truncated to an integer amount):
 * 
 * A) $200-299
 * B) $300-399
 * C) $400-499
 * D) $500-599
 * E) $600-699
 * F) $700-799
 * G) $800-899
 * H) $900-999
 * I) $1,000 and over
 */
import java.security.SecureRandom;
import java.util.Arrays;

public class Commission{
	public static void main(String[] args) {
		SecureRandom rand = new SecureRandom();
		int[] salary = new int[100];
		
		for(int i = 0; i < 100; ++i) {
			salary[i] = 200 + (int) (0.09 * rand.nextInt(12000));
		}
		Arrays.sort(salary);
		
		int count = 0;
		for(int i = 0, hund = 200; i < salary.length; hund += 100) {
			while (i < salary.length && salary[i] < hund + 100) {
				++count;
				++i;
			}
			if (hund < 1000) {
				System.out.printf("$%d-%d: %d\n", hund, hund + 99, count);
				count = 0;
			}
		}
		System.out.printf("$1,000 and over: %d\n", count);
	}
}