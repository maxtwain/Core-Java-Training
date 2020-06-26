public abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Date birthDay;

	public Employee(String firstName, String lastName, String socialSecurityNumber, int birthMonth, int birthDay, int birthYear) {
		this.birthDay = new Date(birthMonth, birthDay, birthYear);
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.birthDay = new Date();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public Date getBirth() {
		return birthDay;
	}

	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(),
				getSocialSecurityNumber());
	}

	public abstract double earnings();
}