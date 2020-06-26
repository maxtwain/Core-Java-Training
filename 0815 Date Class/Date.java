public class Date{
	private int month;
	private int day;
	private int year;
	private static final String[] monthName = {
			"January", 
			"February", 
			"March", 
			"April", 
			"May", 
			"June", 
			"July", 
			"August", 
			"Septembter", 
			"October", 
			"Novemeber", 
			"December"
	};
	
	private static final int[] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public Date(String month, int day, int year) {
		int i = 0;
		for(; monthName[i] != month; ++i) {}
		this.month = i + 1;
		this.day = day;
		this.year = year;
	}
	
	// this constructor does not consider leap year
	public Date(int dayAfterNewYear, int year) {
		int month = 1;
		int daySum = 31;
		for (; daySum < dayAfterNewYear; daySum += daysPerMonth[month]) {
			++month;
		}
		this.month = month;
		this.day = dayAfterNewYear - (daySum - daysPerMonth[month]);
		this.year = year;
	}
	
	public void print0() {
		System.out.printf("%02d/%2d/%4d%n", month, day, year);
	}
	public void print1() {
		System.out.printf("%s %d, %d%n", monthName[month - 1], day, year);
	}
	public void print2() {
		int daySum = 0;
		for (int mCount = 1; mCount < month; ++mCount) {
			daySum += daysPerMonth[mCount];
		}
		daySum += day;
		System.out.printf("%3d %4d%n", daySum, year);
	}
}