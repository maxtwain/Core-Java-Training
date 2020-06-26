public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String social, double wage, double hours) {
		super(firstName, lastName, social);
		this.wage = wage;
		this.hours = hours;
	}
	
	public void setWage(double wage) {
		if (wage < 0) {
			throw new IllegalArgumentException("Wage must be >= 0.0)");
		}
		this.wage = wage;
	}
	public void setHours(double hours) {
		if (hours > 168 || hours < 0) {
			throw new IllegalArgumentException("Hours must be between 0 and 168");
		}
		this.hours = hours;
	}
	
	public double getWage() {
		return wage;
	}
	public double getHours() {
		return hours;
	}
	
	public double earnings() {
		return wage * hours;
	}
	public String toString() {
		return String.format("%swage: %s%nhours: %s%n", super.toString(), wage, hours);
	}
}