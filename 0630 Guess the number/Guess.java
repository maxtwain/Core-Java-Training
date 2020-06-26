/*
 * Write an application that plays "guess the number" as follows: Your program chooses the number to be guessed by selecting a random integer in the rage 1 to 1000.  The application displays the prompt Guess a number between 1 and 1000.  The player inputs a first guess.  If the player's guess is incorrect, your program should display Too high.  Try again.  or Too low.  Try again.  to help the player "zero in" on the correct answer.  The program should prompt the user for the next guess.  When the user enters the correct answer, display Congratulations.  You guessed the number!, and allow the user to choose whether to play again.
 * 
 */
import java.util.Scanner;
import java.security.SecureRandom;

public class Guess {
	private static SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int playAgain = 1; playAgain == 1;) {
			int answer = 1 + rand.nextInt(1000);
			System.out.print("Guess a number between 1 and 1000: ");
			int guess = input.nextInt();
			while (answer != guess) {
				if(guess < answer) {
					System.out.print("Too low.  Try again: ");
				}
				else if (guess > answer) {
					System.out.print("Too high.  Try again: ");
				}
				guess = input.nextInt();
			}
			System.out.println("Congratulations.  You guessed the number!");
			System.out.print("Enter 1 to play again or 0 to quit: ");
			playAgain = input.nextInt();
		}
		
	}
}