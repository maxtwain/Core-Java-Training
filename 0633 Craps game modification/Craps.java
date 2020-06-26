/*
 * Modify the craps program of Fig 6.8 to allow wagering.  Initialize the variable bankBalance to 1000 dollars.  Prompt the player to enter a wager.  Check that wager is less than or equal to bankBalance, and if it's not, have the user reenter wager until a valid wager is entered.  Then, run one game of craps.  If the player wins, increase bankBalance by wager and display the new bankBalance.  If the player loses, decrease bankBalance by wager, display the new bankBalance, check whether bankBalance has become zero and, if so, display the message "Sorry.  You busted!"  As the game progresses, display various messages to create some "chatter," such as "oh, you're going for broke huh?" or "Aw c'mon, take a chance!" or "You're up big.  Now's the time to cash in your chips!".  Implement the "chatter" as a separate method that randomly chooses the string to display.
 * 
 * I am honestly at a disadvantage in this.  I don't know anything about craps except that it is a dice game.
 */
import java.util.Scanner;
import java.security.SecureRandom;

public class Craps {
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	private enum Status {CONTINUE, WON, LOST};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int bankBalance = 1000;
		
		
		while (bankBalance > 0) {
			System.out.printf("Bank balance = %d%n", bankBalance);
			System.out.print("Enter a wager: ");
			int wager = input.nextInt();
			while(wager > bankBalance) {
				System.out.print("Invalid entry.  Enter a wager: ");
				wager = input.nextInt();
			}
			chatter();
			
			int myPoint = 0;
			Status gameStatus;
			
			int sumOfDice = rollDice();
			
			switch (sumOfDice) {
			case SEVEN:
			case YO_LEVEN:
				gameStatus = Status.WON;
				break;
			case SNAKE_EYES:
			case TREY:
			case BOX_CARS:
					gameStatus = Status.LOST;
			break;
			default:
				gameStatus = Status.CONTINUE;
				myPoint = sumOfDice;
				System.out.printf("Point is %d%n", myPoint);
				break;
			}
			
			while (gameStatus == Status.CONTINUE) {
				sumOfDice = rollDice();
				
				if (sumOfDice == myPoint) {
					gameStatus = Status.WON;
				}
				else {
					if (sumOfDice == SEVEN) {
						gameStatus = Status.LOST;
					}
				}
			}
			
			if (gameStatus == Status.WON) {
				System.out.println("Player wins");
				bankBalance += wager;
			}
			else {
				System.out.println("Player looses");
				bankBalance -= wager;
			}
		}
		if(bankBalance == 0) {
			System.out.println("Sorry.  You busted!");
		}
	}
	
	public static int rollDice() {
		int die1 = 1 + randomNumbers.nextInt(6);
		int die2 = 1 + randomNumbers.nextInt(6);
		
		int sum = die1 + die2;
		
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
		
		return sum;
	}
	
	public static void chatter() {
		int message = randomNumbers.nextInt(3);
		
		switch (message) {
		case 0:
			System.out.println("Oh, you're going for broke, huh?");
		case 1:
			System.out.println("Aw c'mon, take a chance!");
		case 2:
			System.out.println("You're up big.  Now's the time to cash in your chips!");
		}
	}
}