/*
 * In this problem you'll recreate the classic race of the tortoise and the hair.  You'll use random number generation to develop a simulation of this memorable event.
 * Our contenders begin the race at square 1 of 70 squares.  Each square represents a possible position along the race course.  The finish line is at square 70.  The first contender to reach or pass square 70 is rewarded with a pail of fresh carrots and lettuce.  The course weaves its way up the side of a slippery mountain, so occasionally the contenders lose ground.
 * A clock ticks once per second.  With each tick of the clock, your application should adjust the position of the animals according to the rules in Fig 7.32.  Use the variables to keep track of the position of the animals (i.e. position numbers are 1-70).  Start each animal at position 1 (the starting game).  If an animal slips left before square 1, move it back to square 1.
 * 
 * Animal	Move Type	Percent	Actual Move
 * Tortoise	Fast plot	50%		3 right
 * 			Slip		20%		6 left
 * 			Slow plod	30%		1 right
 * Hare		Sleep		20%		0
 * 			Big hop		20%		9 right
 * 			Big slip	10%		12 left
 * 			Small hop	30%		1 right
 * 			Small slip	20%		2 left
 * 
 * Generate the percentages by producing a random integer i in the range 1 <= i <= 10.  For the tortoise, perform a fast plod when 1 <= i <= 5, a slip when 6 <= i <= 7, or a slow plod when 8 >= i <= 10.  Use a similar technique to move the hare.
 * Begin the race by displaying:
 * BANG !!!!!
 * AND THEY'RE OFF !!!!!
 * 
 * Then for each tick of the clock (each iteration of a loop), display a 70 position line showing the letter T in the position of the tortoise and the letter H in the position of the hare.  Occasionally, the contenders will land on the same square.  In this case, the tortoise bites the hare, and your application should display OUCH!!! beginning at that position.  All output positions other than the T, the H or the OUCH!!! (in case of a tie) should be blank.
 * After each line is displayed, test for whether either animal has reached or passed square 70.  If so, display the winner and terminate the simulation.  If the tortoise wins, display "TORTOISE WINS!!! YAY!!!"  If the hare wins, display "Hare wins.  Yuch."  If both animals win on the same tick of the clock, you may want to favor the tortoise (the underdog), or you may want to display "It's a tie."  If neither animal wins, perform the loop again to simulate the next tick of the clock.  When you're ready to run your application, assemble a group of fans to watch the race.  You'll be amazed at how involved your audience gets!
 * Later in the book we introduce a number of Java capabilities, such as graphics, images, animation, sound, and multithreading.  As you study those features, you might enjoy enhancing your tortoise and hare contest simulation.
 */
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class RandomRace{
	public static final int SIZE = 70;
	public static final SecureRandom rand = new SecureRandom();
	
	public static void main(String[] args) {
		int torPos = 1;
		int harPos = 1;
		
		while (torPos < SIZE && harPos < SIZE) {
			int tMove = moveTor();
			int hMove = moveHar();
			torPos += tMove;
			harPos += hMove;
			if (torPos < 1) {
				torPos = 1;
			}
			if (harPos < 1) {
				harPos = 1;
			}
			
			printState(tMove, hMove, torPos, harPos);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		printFinish(torPos, harPos);
	}
	
	public static void printFinish(int torPos, int harPos) {
		if (torPos > harPos) {
			System.out.println("TORTOISE WINS !!!!!");
		}
		else if (harPos > torPos) {
			System.out.println("HARE WINS !!!!!");
		}
		else {
			System.out.println("It's a tie.");
		}
	}
	
	public static void printState(int tMove, int hMove, int torPos, int harPos) {
		for (int pos = 1; pos < SIZE; ++pos) {
			if (pos == torPos) {
				System.out.printf("%c", 'T');
			}
			else {
				System.out.printf("%c", ' ');
			}
		}
		System.out.println();
		
		for (int pos = 1; pos < SIZE; ++pos) {
			System.out.printf("%c", '=');
		}
		System.out.println();
		
		for (int pos = 1; pos < SIZE; ++pos) {
			if (pos == harPos) {
				System.out.printf("%c", 'H');
			}
			else {
				System.out.printf("%c", ' ');
			}
		}
		System.out.printf("%n%n");
		
		System.out.printf("%12s%-20s%n", "Tortoise: ", torAction(tMove));
		System.out.printf("%12s%-20s%n%n", "Hare: ", harAction(hMove));
	}
	
	public static String torAction(int move) {
		switch (move) {
		case 3:
			return "Fast plod";
		case -6:
			return "Slip";
		}
		return "Slow plod";
	}
	
	public static String harAction(int move) {
		switch (move) {
		case 0:
			return "Sleep";
		case 9:
			return "Big hop";
		case -12:
			return "Big slip";
		case 1:
			return "Small hop";
		}
		return "Small slip";
	}
	
	public static int moveTor() {
		int r = rand.nextInt(10);
		if (r < 5) {
			return 3;
		}
		else if (r < 7) {
			return -6;
		}
		return 1;
	}
	
	public static int moveHar() {
		int r = rand.nextInt(10);
		if (r < 2) {
			return 0;
		}
		else if (r < 4) {
			return 9;
		}
		else if (r < 5) {
			return -12;
		}
		else if (r < 8) {
			return 1;
		}
		return -2;
	}
}