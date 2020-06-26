/*
 * An interesting puzzler for chess buffs is the Knight's Tour problem, originally proposed by the mathematician Euler.  Can the knight piece move around an empty chessboard and touch each of the 64 squares once and only once?  We study this intriguing problem in depth here:
 * The knight makes only L shaped moves (two spaces in one direction and one space in a perpendicular direction).  Thus, as shows in Fig. 7.30, from a square near the middle of an empty chessboard, the knight (labeled K) can make eight different moves (numbered 0 through 7).
 * 
 * A) Draw an eight by eight chessboard on a sheet of paper, and attempt a Knight's Tour by hand.  Put a 1 in the starting square, a 2 in the second square, a 3 in the third, and so on.  Before starting the tour, estimate how far you think you'll get, remembering that a full tour consists of 64 moves.  How far did you get?  Was this close to your estimate?
 * 
 * B) How let's develop an application that will move the knight around a chessboard.  The board is represented by an eight by eight two dimensional array board.  Each square is initialized to zero.  We describe each of the eight possible moves in terms of its horizontal and vertical components.  FDor example, a move of type 0, as shows in Fig 7.30, consists of moving two squares horizontally to the right and one square vertically upward.  A move of type 2 consists of moving one square horizontally to the left and two squares vertically upward.  Horizontal moves to the left and vertical moves upward are indicated with negative numbers.  The eight moves may be described by two one dimensional arrays, horizontal and vertical, as follows:
 * 
 * horizontal[0] = 2	vertical[0] = -1
 * horizontal[1] = 1	vertical[1] = -2
 * horizontal[2] = -1	vertical[2] = -2
 * horizontal[3] = -2	vertical[3] = -1
 * horizontal[4] = -2	vertical[4] = 1
 * horizontal[5] = -1	vertical[5] = 2
 * horizontal[6] = 1	vertical[6] = 2
 * horizontal[7] = 2	vertical[7] = 1
 * 
 * Let the variables currentRow and currentColumn indicate the row and column, respectively, of the knight's current position.  To make a move of type moveNumber, where moveNumber is between 0 and 7, your application should use the statements:
 * 
 * currentRow += vertical[moveNumber];
 * currentCoumn += horizontal[moveNumber];
 * 
 * Write and application to move the knight around the chessboard.  Keep a counter that varies from 1 to 64.  Record the latest count in each square the knight moves to.  Test each potential move to see if the knight has already visited that square.  Test every potential move to ensure that the knight does not land off the chessboard.  Run the application.  How many moves did the knight make?
 * 
 * C) After attempting to write and run a Knight's Tour application you've probably developed some valuable insights.  We'll use these insights to develop a heuristic (a common sense rule) for moving the knight.  Heuristics do not guarantee success, but a carefully developed heuristic greatly improves the chance of success.  You may have observed that the outer squares are more troublesome than the squares nearer the center of the board.  In fact, the most troublesome or inaccessible squares are the four corners.  Intuition may suggest that you should attempt to move the knight to the most troublesome squares first and leave open those that are easiest to get to, so that when the board gets congested near the end of the tour, there will be a greater chance of success.
 * We could develop an "accessibility heuristic" by classifying each of the squares according to how accessible it is and always moving the knight (using the kngiht's L shaped moves) to the most inaccessible square.  We labeled a two dimensional array accessibility with numbers indicating from how many squares each particular square is accessible.  On a blank chessboard, each of the 16 squares nearest the center is rated as 8, each corner square is rated as 2, and the other squares have accessibility numbers of 3, 4, or 6 as follows:
 * 
 * 2 3 4 4 4 4 3 2
 * 3 4 6 6 6 6 4 3
 * 4 6 8 8 8 8 6 4
 * 4 6 8 8 8 8 6 4
 * 4 6 8 8 8 8 6 4
 * 4 6 8 8 8 8 6 4
 * 3 4 6 6 6 6 4 3
 * 2 3 4 4 4 4 3 2
 * 
 * Write a new version of the Knight's Tour, using the accessibility heuristic.  The knight should always move to the square with the lowest accessibility number.  In case of a tie, the knight may move to any of the tied squares.  Therefore, the tour may begin in any of the four corners.  [Note: As the knight moves around the chessboard, your application should reduce the accessibility numbers as more squares become occupied.  In this way, at any given time during the tour, each available square's accessibility number will remain equal to precisely the number of squares from which that square may be reached.]  Run this version of your application.  Did you get a full tour?  Modify the application to run 64 tours, one starting from each square of the chessboard.  How many full tours did you get?
 * 
 * D) Write a version of the Knight's Tour application that, when encountering a tie between two or more squares, decides what square to choose by looking ahead to those squares reachable from the "tied" squares.  Your application should move to the tied square for which the next move would arrive at a square with the lowest accessibility number.
 * 
 * 
 * 
 * I didn't write this program in the way I was instructed to.  I have already done it in C, and I felt this would be a good exercise in object orientation.  Also, the second half of this exercise is asking for a very different program than the first part.  I believe that the next exercise then asks for very much the same thing as this second half.  I will then just make another version of this program for the next exercise.
 */
import java.util.Arrays;
import java.util.Scanner;

public class KnightTourUser{
	public static final int SIZE = 8;
	
	
	public static void main(String[] args) {
		char[][] board = new char[SIZE][SIZE];
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		Knight knight = new Knight(0, 0);
		markBoard(board, knight);
		Scanner input = new Scanner(System.in);
		
		int direction;
		int moveCount = 1;
		while (moveAvailable(board, knight)) {
			printBoard(board, knight);
			System.out.print("Enter move: ");
			direction = input.nextInt();
			while (!(direction >=0 && direction <= 7)) {
				System.out.print("Invalid entry.  Enter valid move: ");
				direction = input.nextInt();
			}
			moveKnight(board, knight, direction);
			++moveCount;
		}
		
		System.out.printf("Game Over: %d moves%n", moveCount);
		printBoard(board, knight);
	}
	
	// marks the current knight position as unavailable
	public static void markBoard(char[][] board, Knight knight) {
		board[knight.getRow()][knight.getCol()] = '#';
	}
	
	public static void moveKnight(char[][] board, Knight knight, int direction) {
		while (knight.kMoveRow[direction] == -1 || knight.kMoveCol[direction] == -1) {
			System.out.print("Invalid entry.  Enter valid move: ");
			Scanner input = new Scanner(System.in);
			direction = input.nextInt();
		}
		knight.setKPos(knight.kMoveRow[direction], knight.kMoveCol[direction]);
		markBoard(board, knight);
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
	
	// prints a modified copy of board.  board is not changed
	public static void printBoard(char[][] board, Knight knight) {
		char[][] pBoard = new char[SIZE][SIZE];
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				pBoard[row][col] = board[row][col];
			}
		}
		pBoard[knight.getRow()][knight.getCol()] = 'K';
		for (int i = 0; i < 8; ++i) {
			if (knight.kMoveRow[i] != -1 && knight.kMoveCol[i] != -1 &&
					pBoard[knight.kMoveRow[i]][knight.kMoveCol[i]] == ' ') {
				pBoard[knight.kMoveRow[i]][knight.kMoveCol[i]] = (char) (i + 48);
			}
		}
		
		for(int row = -1; row < SIZE + 1; ++row) {
			for(int col = -1; col < SIZE + 1; ++col) {
				if (row == -1 || row == SIZE) {
					System.out.printf("%c ", '-');
				}
				else if (col == -1 || col == SIZE) {
					System.out.printf("%c ", '|');
				}
				else {
					System.out.printf("%c ", pBoard[row][col]);
				}
			}
			System.out.println();
		}
	}
}