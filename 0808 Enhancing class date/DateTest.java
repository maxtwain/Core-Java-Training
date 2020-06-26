/*
 * Modify class Date of Fig. 8.7 to perform error checking on the initializer values for variables month, day, and year (currently it validates only the month and the day).  Provide a method nextDay to increment the day by one.  Write a program that tests method nextDay in a loop that prints the date during each iteration to illustrate that the method works correctly.  Test the following cases:
 * 
 * A) incrementing into the next month
 * 
 * B) incrementing into the next year
 */

public class DateTest{
	public static void main(String[] args) {
		Date d1 = new Date(12, 31, 2000);
		
		d1.nextDay();
		System.out.println(d1.toString());
	}
}