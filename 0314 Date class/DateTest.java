/*
 * Create a class called Date that includes 
 * three instance variables - a month (type int),
 * a day (type int), and a year (type int).  
 * Provide a constructor that initializes the three instance
 * variables and assumes that the values provided 
 * are correct.  Provide a set and a get method for each
 * instance variable.  Provide a method displayDate 
 * that displays the month, day, and year separated by
 * forward slashes.  Write a test app named DateTest 
 * that demonstrates class Date's capabilities.
 */

public class DateTest{
	public static void main(String[] args) {
		Date d0 = new Date(1, 1, 1111);
		
		System.out.printf("%10s%10s%10s%n", "Month", "Day", "Year");
		
		System.out.printf("%10d%10d%10d%n", d0.getMonth(), d0.getDay(), d0.getYear());
		d0.displayDate();
		
		d0.setMonth(2);
		d0.setDay(22);
		d0.setYear(2222);
		
		System.out.printf("%10d%10d%10d%n", d0.getMonth(), d0.getDay(), d0.getYear());
		d0.displayDate();
	}
}