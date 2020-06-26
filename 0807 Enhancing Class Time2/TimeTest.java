/*
 * Modify class Time2 of Fig. 8.5 to include a tick method that increments the time stored in a Time2 object by one second.  Provide method incrementMinute to increment the minute by one and method incrementHour to increment the hour by one.  Write a program that tests the tick method, the incrementMinute method and the incrementHour method to ensure that they work correctly.  Be sure to test the following cases:
 * 
 * A) incrementing into the next minute
 * 
 * B) incrementing into the next hour and
 * 
 * C) incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM).
 * 
 */

public class TimeTest{
	public static void main(String[] args) {
		Time2 t1 = new Time2(23, 59, 59);
		Time2 t2 = new Time2(23, 59, 59);
		Time2 t3 = new Time2(23, 59, 59);
		
		t1.tick();
		t2.incrementMinute();
		t3.incrementHour();
		
		System.out.println("Constructed with:");
		displayTime("t1: all default arguments", t1);
		displayTime("t2: hour specified; default minute and second", t2);
		displayTime("t3: hour and minute specified; default second", t3);
		
		try {
			Time2 t6 = new Time2(27, 74, 99);
		}
		catch (IllegalArgumentException e) {
			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
		}
	}
	
	private static void displayTime(String header, Time2 t) {
		System.out.printf("%s%n  %s%n  %s%n", header, t.toUniversalString(), t.toString());
	}
}