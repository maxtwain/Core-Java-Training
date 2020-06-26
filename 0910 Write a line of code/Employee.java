public class Employee{
	private String firstName;
	private String lastName;
	private String socialNum;
	
	public Employee(String firstName, String lastName, String socialNum) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialNum = socialNum;
	}
	public Employee() {
		this.firstName = "John";
		this.lastName = "Doe";
		this.socialNum = "123456789";
	}
	
	public void setFirst(String first) {
		this.firstName = first;
	}
	public void setLast(String last) {
		this.lastName = last;
	}
	public void setSocial(String social) {
		this.socialNum = social;
	}
	
	public String getFirst() {
		return firstName;
	}
	public String getLast() {
		return lastName;
	}
	public String getSocial() {
		return socialNum;
	}
	
	public String toString() {
		return String.format("%s, %s: %s", lastName, firstName, socialNum);
	}
}