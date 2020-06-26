public class Employee{
	private String firstName;
	private String lastName;
	private String social;
	
	public Employee(String firstName, String lastName, String social) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.social = social;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSocialSecurityNumber(String social) {
		this.social = social;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSocialSecurityNumber() {
		return social;
	}
	
	public String toString() {
		return String.format("employee: %s %s%nsocial security number: %s%n", 
				firstName, lastName, social);
	}
}