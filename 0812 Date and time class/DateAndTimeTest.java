/*
 * Create class DateAndTime that combines the modified Time2 class of Exercise 8.7 and the modified Date class of Exercise 8.8.  Modify method incrementHour to call method nextDay if the time is incremented into the next day.  Modify methods toString and toUniversalString to output the date in addition to the time.  Write a program to test the new class DateAndTime.  Specifically, test incrementing the time to the next day.
 * 
 * 
 * 
 */


public class DateAndTimeTest{
	public static void main(String[] args) {
		DateAndTime d1 = new DateAndTime(23, 59, 59, 12, 31, 2000);
		DateAndTime d2 = new DateAndTime(23, 59, 59, 12, 31, 2000);
		DateAndTime d3 = new DateAndTime(23, 59, 59, 12, 31, 2000);
		DateAndTime d4 = new DateAndTime(23, 59, 59, 12, 31, 2000);
		
		System.out.printf("d1: %s%n%s%n%n", d1.toUniversalString(), d1.toString());
		System.out.printf("d2: %s%n%s%n%n", d2.toUniversalString(), d2.toString());
		System.out.printf("d3: %s%n%s%n%n", d3.toUniversalString(), d3.toString());
		System.out.printf("d4: %s%n%s%n%n", d4.toUniversalString(), d4.toString());
		
		d1.tick();
		d2.incrementMinute();
		d3.incrementHour();
		d4.nextDay();
		
		System.out.printf("d1: %s%n%s%n%n", d1.toUniversalString(), d1.toString());
		System.out.printf("d2: %s%n%s%n%n", d2.toUniversalString(), d2.toString());
		System.out.printf("d3: %s%n%s%n%n", d3.toUniversalString(), d3.toString());
		System.out.printf("d4: %s%n%s%n%n", d4.toUniversalString(), d4.toString());
	}
}