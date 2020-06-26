public class Date{
	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	public int getYear() {
		return this.year;
	}
	
	public void displayDate() {
		System.out.printf("%2d/%2d/%4d%n", this.month, this.day, this.year);
	}
}