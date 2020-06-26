/* Modify class Account to provide a method called withdraw that withdraws money from an Account.
Ensure that the withdrawal amount does not exceed the Account's balance.  If it does, the balance
should be left unchanged and the method should print a message indicating "Withdrawal amount
exceeded account balance."  Modify class AccountText to test method withdraw.
*/

import java.util.Scanner;

public class AccountTest{
	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 50.00);
		Account account2 = new Account("John Blue", -7.53);
		
		System.out.printf("%s balance: $%.2f%n",
				account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",
				account2.getName(), account2.getBalance());
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter deposit amount for account 1: ");
		double amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account 1 balance%n%n",
				amount);
		account1.deposit(amount);
		
		System.out.printf("%s balance: $%.2f%n",
				account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",
				account2.getName(), account2.getBalance());
		
		System.out.print("Enter deposit amount for account2: ");
		amount = input.nextDouble();
		System.out.printf("%nadding %.2f to account 2 balance%n%n",
				amount);
		account2.deposit(amount);
		
		System.out.printf("%s balance: $%.2f%n",
				account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",
				account2.getName(), account2.getBalance());
		
		// New code:
		
		System.out.print("Enter withdrawal amount for account 1: ");
		amount = input.nextDouble();
		System.out.printf("%nsubtracting %.2f from account 1 balance%n%n",
				amount);
		account1.withdraw(amount);
		
		System.out.printf("%s balance: $%.2f%n",
				account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",
				account2.getName(), account2.getBalance());
		
		System.out.print("Enter withdrawal amount for account2: ");
		amount = input.nextDouble();
		System.out.printf("%nsubtracting %.2f from account 2 balance%n%n",
				amount);
		account2.withdraw(amount);
		
		System.out.printf("%s balance: $%.2f%n",
				account1.getName(), account1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",
				account2.getName(), account2.getBalance());
		
	}
}