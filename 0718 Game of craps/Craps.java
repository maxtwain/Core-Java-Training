/*
 * Write an application that runs 1,000,000 games of craps (Fig. 6.8) and answers the following questions:
 * 
 * A) How many games are won on the first roll, second roll, ..., twentieth roll, and after the twentieth roll?
 * 
 * B) How many games are lost on the first roll, second roll, ..., twentieth roll, and after the twentieth roll? 
 * 
 * C) What are the chances of winning at craps? [Note: You should discover that craps is one of the fairest casino games.  What do you suppose this means?]
 * 
 * D) What is the average length of a game of craps?
 * 
 * E) Do the chances of winning improve with the length of the game?
 * 
 * 
 * 
 * 1,000 games should be enough.  There is no reason to make the program take an excessively long time to run.
 */
import java.security.SecureRandom;

public class Craps{
	private static final int MAX_GAMES = 1000;
	private static final int RECORD_SIZE = 22;
	private static final SecureRandom rand = new SecureRandom();
	private enum Status {CONTINUE, WON, LOST};
	
	public static void main(String[] args) {
		int[][] gameRecord = new int[RECORD_SIZE][2];
		
		for (int game = 0; game < MAX_GAMES; ++game) {
			oneGame(gameRecord);
		}
		
		int winSum = 0;
		int losSum = 0;
		int rollCount = 0;
		System.out.printf("%8s%8s%8s%n", "Rolls", "Wins", "Losses");
		for (int roll = 1; roll < RECORD_SIZE; ++roll) {
			if (roll < 21) {
				System.out.printf("%8d", roll);
			}
			else {
				System.out.printf("%8s", "+21");
			}
			winSum += gameRecord[roll][1];
			losSum += gameRecord[roll][0];
			rollCount += roll * (gameRecord[roll][1] + gameRecord[roll][0]);
			for (int winLoose = 1; winLoose >= 0; --winLoose) {
				System.out.printf("%8d", gameRecord[roll][winLoose]);
			}
			System.out.println();
		}
		System.out.printf("%8s%8d%8d%n", "Total", winSum, losSum);
		System.out.printf("%-17s%-5.3f rolls%n", "Ave Game Length:", 
				(double) rollCount / MAX_GAMES);
	}
	
	public static int rollDice() {
		return 1 + rand.nextInt(6) + 1 + rand.nextInt(6);
	}
	
	public static void oneGame(int[][] gameRecord) {
		int myPoint = 0;
		Status gameStatus;
		int sumOfDice = rollDice();
		int rollCount = 1;
		
		switch (sumOfDice) {
		case 7:
		case 11:
			gameStatus = Status.WON;
			break;
		case 2:
		case 3:
		case 12:
			gameStatus = Status.LOST;
		default:
			gameStatus = Status.CONTINUE;
			myPoint = sumOfDice;
			break;
		}
		
		while (gameStatus == Status.CONTINUE) {
			sumOfDice = rollDice();
			if (rollCount + 1 < RECORD_SIZE) {
				++rollCount;
			}
			if(sumOfDice == myPoint) {
				gameStatus = Status.WON;
			}
			else if (sumOfDice == 7) {
				gameStatus = Status.LOST;
			}
		}
		
		if (gameStatus == Status.WON) {
			++gameRecord[rollCount][1];
			return;
		}
		else {
			++gameRecord[rollCount][0];
			return;
		}
	}
}