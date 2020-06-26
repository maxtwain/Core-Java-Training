/*
 * Develop a Java application that determines whether 
 * any of several department store customers has 
 * exceeded the credit limit on a charge account.  
 * For each customer the following facts are available:
 * 
 * 		-account number
 * 		-balance at the beginning of the month
 * 		-total of all items charged by the customer 
 * this	month
 * 		-total of all credits applied to the 
 * customer's account this month
 * 		-allowed credit limit
 * 
 * The program should input all these facts as 
 * integers, calculate the new balance (= 
 * beginning balance + charges - credits), 
 * display the new balance, and determine 
 * whether the new balance exceeds the 
 * customer's credit limit.  For those 
 * customers whose credit limit is exceeded, 
 * the program should display the message 
 * "Credit limit exceeded".
 * 
 */

public class AccountTest{
	public static void main(String[] args) {
		Account a0 = new Account("85432", 0, 0, 0, 10);
		Account a1 = new Account("83453", 10, 0, 0, 10);
		Account a2 = new Account("845f3", 0, 15, 0, 10);
		Account a3 = new Account("85adf", 10, 0, 10, 10);
	}
}