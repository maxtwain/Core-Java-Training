/*
 * In the AccountTest class, method main contains six 
 * statements that each display an Account object's name 
 * and balance.  Study these statements and you'll notice 
 * that they different only in the Account object being 
 * manipulated - account1 or account2.  In this exercise, 
 * you'll define a new diplayAccount method that contains 
 * one copy of that output statement.  The method's 
 * parameter will be an Account object and the method will 
 * output the object's name and balance.  You'll then 
 * replace the six duplicated statements in main with 
 * calls to diplayAccount, passing as an argument the 
 * specific Account object to output.  
 *                                     Modify class 
 * AccountTest to declare method displayAccount after 
 * the closing right brace of main and before the closing 
 * right brace of class AccountTest.  Replace the comment 
 * in the method's body with a statement that displays 
 * accountToDisplay's name and balance  Recall that main 
 * is a static method, so it can be called without first 
 * creating an object of the class in which main is 
 * declared.  We also declared method displayAccount as 
 * a static method.  When main needs to call another 
 * method in the same class without first creating an 
 * object of that class, the other method also must be 
 * declared static.  
 *                   Once you've completed 
 * diplsayAccount's declaration, modify main to replace 
 * the statements that display each Account's name and 
 * balance with calls to displayAccount - each receiving 
 * as its arguments the account1 or account2 object, as 
 * appropriate.  Then, test the updated AccountTest class 
 * to ensure that it produces the same output as shows in 
 * Fig. 3.9.
 */

import java.util.Scanner;

public class AccountTest{
	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 50.00);
		Account account2 = new Account("John Blue", -7.53);
		
		displayAccount(account1);
		displayAccount(account2);
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter deposit amount for account 1: ");
		double amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account 1 balance%n%n",
				amount);
		account1.deposit(amount);
		
		displayAccount(account1);
		displayAccount(account2);
		
		System.out.print("Enter deposit amount for account2: ");
		amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account 2 balance%n%n",
				amount);
		account2.deposit(amount);
		
		displayAccount(account1);
		displayAccount(account2);
		
		System.out.print("Enter withdrawal amount for account 1: ");
		amount = input.nextDouble();
		System.out.printf("%nsubtracting %.2f from account 1 balance%n%n",
				amount);
		account1.withdraw(amount);
		
		displayAccount(account1);
		displayAccount(account2);
		
		System.out.print("Enter withdrawal amount for account2: ");
		amount = input.nextDouble();
		System.out.printf("%nsubtracting %.2f from account 2 balance%n%n",
				amount);
		account2.withdraw(amount);
		
		displayAccount(account1);
		displayAccount(account2);
	}
	
	public static void displayAccount(Account accountToDisplay) {
		System.out.printf("%s balance: $%.2f%n",
				accountToDisplay.getName(), accountToDisplay.getBalance());
	}
}