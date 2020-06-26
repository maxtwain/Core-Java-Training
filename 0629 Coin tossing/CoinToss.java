/*
 * Write an application that simulates coin tossing.  Let the program toss 
 * a coin each time the user chooses the "Toss Coin" menu option.  Count 
 * the number of times each side of the coin appears.  Display the result.  
 * The program should call a separate method flip that takes no arguments 
 * and returns a value from a Coin enum (HEADS and TAILS).
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class CoinToss{
	private static final SecureRandom rand = new SecureRandom();
	
	private enum Coin {HEADS, TAILS};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Press 1 to flip a coin or 0 to quit: ");
		int choice = input.nextInt();
		int totFlips = 0;
		int headCount = 0;
		while(choice == 1) {
			Coin face = flip();
			++totFlips;
			if (face == Coin.HEADS) {
				++headCount;
			}
			
			System.out.print("Press 1 to flip a coin or 0 to quit: ");
			choice = input.nextInt();
		}
		
		System.out.printf("Flips = %d  Head = %d  Tails = %d%n", 
				totFlips, headCount, totFlips - headCount);
	}
	
	public static Coin flip() {
		return rand.nextInt(2) == 1 ? Coin.HEADS : Coin.TAILS;
	}
}