/*
 * Create class Date with the following capabilities:
 * 
 * A) Output the date in multiple formats, such as
 * 
 * MM/DD/YYYY
 * July 14, 1992
 * DDD YYYY
 * 
 * B) Use overloaded constructors to create Date objects initialized with dates of the formats in part (a).  In the first case the constructor should receive three integer values.  In the second case it should receive a String and two integer values.  In the third case it should receive two integer values, the first of which represents the day number in the year.
 */

public class DateTest{
	public static void main(String[] args) {
		Date d0 = new Date(12, 23, 1900);
		Date d1 = new Date("July", 14, 1992);
		Date d2 = new Date(143, 1943);
		Date d3 = new Date(32, 1943);
		
		d0.print0();
		d1.print0();
		d1.print1();
		d2.print2();
		d2.print0();
		d3.print1();
	}
}