public class DateAndTime{
	private static final int[] daysPerMonth =
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private int hour;
	private int minute;
	private int second;
	private int month;
	private int day;
	private int year;
	
	public DateAndTime() {
		this(0, 0, 0, 1, 1, 1900);
	}
	
	public DateAndTime(int hour) {
		this(hour, 0, 0, 1, 1, 1900);
	}
	
	public DateAndTime (int hour, int minute) {
		this(hour, minute, 0, 1, 1, 1900);
	}
	
	public DateAndTime(int hour, int minute, int second, int month, int day, int year) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		if (year < 1900 || year > 2020) {
			throw new IllegalArgumentException(
					"year (" + year + ") must be 1900-2020");
		}
		
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException(
					"month (" + month + ") must be 1-12");
		}
		
		if (day <= 0 ||
				(day > daysPerMonth[month] && !(month == 2 && day == 29))) {
			throw new IllegalArgumentException("day (" + day +
					") out-of-range for the specified month and year");
		}
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.month = month;
		this.day = day;
		this.year = year;
		
		System.out.printf("Date object constructor for date %s%n", this);
	}
	
	public DateAndTime(DateAndTime date) {
		this(date.hour, date.minute, date.second, date.month, date.day, date.year);
	}
	
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.minute = minute;
	}
	
	public void setSecond (int second) {
		if (second > 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.second = second;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d %d/%d/%d", getHour(), getMinute(), getSecond(), month, day, year);
	}
	
	public String toString() {
		return String.format("%d:%02d:%02d %s %d/%d/%d", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"), month, day, year);
	}
	
	public void tick() {
		++second;
		while (second > 59) {
			second -= 60;
			this.incrementMinute();
		}
	}
	
	public void incrementMinute() {
		++minute;
		while (minute > 59) {
			minute -= 60;
			this.incrementHour();
		}
	}
	
	public void incrementHour() {
		++hour;
		while (hour > 23) {
			hour -= 24;
			this.nextDay();
		}
	}
	
	public void nextDay() {
		++day;
		while (day > daysPerMonth[month]) {
			day -= daysPerMonth[month];
			++month;
			while (month > 12) {
				month -= 12;
				++year;
			}
		}
	}
}