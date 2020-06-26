/*
 * In part (c) of Exercise 7.22, we developed a solution to the Knight's Tour problem.  The approach used, called the "accessibility heuristic," generates many solutions and executes efficiently.
 * As computers continue to increase in power, we'll be able to solve more problems with sheer computer power and relatively unsophisticated algorithms.  Let's call this approach "brute-force" problem solving.
 * 
 * A) Use random number generation to enable to knight to walk around the chessboard (in its legitimate L shaped moves) at random.  Your application should run one tour and display the final chessboard.  How far did the knight get?
 * 
 * B) Most likely, the application is part (a) produced a relatively short tour.  Now modify your application to attempt 1,000 tours.  Use a one dimensional array to keep track of the number of tours of each length.  When your application finishes attempting the 1,000 tours, it should display this information in neat tabular format.  What was the best result?
 * C) Most likely, the application in part (b) gave you some "respectable" tours, but no full tours.  Now let your application run until it produces a full tour. [Caution: This version of the application could run for hours on a powerful computer.]  Once again, keep a table of the number of tours of each length, and display this table when the first full tour is found.  How many tours did your application attempt before producing a full tour?  How much time did it take?
 * D) Compare the brute force version of the Knight's Tour with the accessibility heuristic version.  Which required a more careful study of the problem?  Which algorithm was more difficult to develop?  Which required more computer power?  could we be certain (in advance) of obtaining a full tour with the brute force approach?  Argue the pros and cons of brute force problem solving in general.
 * 
 * 
 * 
 * I know that an accessibility heuristic always solves a knight's tour. For Part A, I have already printed the board in Exercise 22.  If these knight's tour exercises were organized better, the first exercise would be a user driven version.  The second exercise would be this random version.  A third exercise would be an AI heuristic version.
 */
import java.security.SecureRandom;
import java.util.Arrays;

public class KnightTourRand{
	public static final SecureRandom rand = new SecureRandom();
	public static final int SIZE = 8;
	public static final int GAMES = 1000;
	
	public static void main(String[] args) {
		int[] record = new int[65];
		char[][] board = new char[SIZE][SIZE];
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		Knight knight = new Knight(rand.nextInt(8), rand.nextInt(8));
		markBoard(board, knight);
		
		int moveCount;
		for (int g = 0; g < GAMES; ++g) {
			moveCount = 0;
			while(moveAvailable(board, knight)) {
				moveKnight(board, knight);
				++moveCount;
			}
			++record[moveCount];
			
			// new game
			for (int row = 0; row < SIZE; ++row) {
				Arrays.fill(board[row], ' ');
			}
			knight.setKPos(rand.nextInt(8), rand.nextInt(8));
			markBoard(board, knight);
		}
		
		System.out.printf("%-6s%s%n", "Move", "Count");
		for (int i = 1; i < record.length; ++i) {
			System.out.printf("%-6d%d%n", i, record[i]);
		}
		
	}
	
	public static void moveKnight(char[][] board, Knight knight) {
		int direction = rand.nextInt(8);
		while (knight.kMoveRow[direction] == -1 || knight.kMoveCol[direction] == -1 ||
				board[knight.kMoveRow[direction]][knight.kMoveCol[direction]] != ' ') {
			direction = rand.nextInt(8);
		}
		knight.setKPos(knight.kMoveRow[direction], knight.kMoveCol[direction]);
		markBoard(board, knight);
	}
	
	// marks the current knight position as unavailable
	public static void markBoard(char[][] board, Knight knight) {
		board[knight.getRow()][knight.getCol()] = '#';
	}
	
	public static boolean moveAvailable(char[][] board, Knight knight) {
		for (int i = 0; i < SIZE; ++i) {
			if (knight.kMoveRow[i] != -1 && knight.kMoveRow[i] != -1 &&
					board[knight.kMoveRow[i]][knight.kMoveCol[i]] == ' ') {
				return true;
			}
		}
		return false;
	}
}