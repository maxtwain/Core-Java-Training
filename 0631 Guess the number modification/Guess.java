/*
 * Modify the program of Exercise 6.30 to count the number of guesses the player makes.  If the number is 10 or fewer, display Either you know the secret or you got lucky!  If the player guesses the number in 10 tries, display Aha! You know the secret!  If the player makes more than 10 guesses, display You should be able to do better!  Why should it take no more than 10 guesses?  Well, with each "good guess," the player should be able to eliminate half of the numbers, then half of the remaining numbers, and so on.
 */
import java.util.Scanner;
import java.security.SecureRandom;

public class Guess {
	private static SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int guessCount = 0;
		for(int playAgain = 1; playAgain == 1;) {
			int answer = 1 + rand.nextInt(1000);
			System.out.print("Guess a number between 1 and 1000: ");
			int guess = input.nextInt();
			++guessCount;
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
			if (guessCount < 10) {
				System.out.println("Either you know the secret or you got lucky!");
			}
			else if (guessCount == 10) {
				System.out.println("Aha!  You know the secret!");
			}
			else {
				System.out.println("You should be able to do better!");
			}
			System.out.print("Enter 1 to play again or 0 to quit: ");
			playAgain = input.nextInt();
		}
		
	}
}