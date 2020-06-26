/*
 * In this exercise, you'll develop several brute force approaches to solving the Eight Queens problem introduced in Exercise 7.24.
 * 
 * A) Use the random brute force technique developed in Exercise 7.23 to solve the Eight Queens problem.
 * 
 * B) Use an exhaustive technique (try all possible combinations of eight queens on the chessboard) to solve the Eight Queens problem.
 * 
 * C) Why might the exhaustive brute force approach not be appropriate for solving the Knight's Tour problem?
 * 
 * D) Compare and contrast the random brute force and exhaustive brute force approaches.
 * 
 * 
 * 
 * I've done this before with C.  I doubt the book authors actually did this problem, because the exhaustive approach works better than any other.  A heuristic doesn't work well for Eight Queens because there are too many squares with the same heuristic value to choose from.  A random heuristic would work better than just an automated min heuristic value chooser, but this is still not as good as exhaustive.
 */
import java.util.Arrays;

public class EightQueenExhaust{
	public static final int SIZE = 8;
	
	public static void main(String[] args) {
		char[][] board = new char[SIZE][SIZE];
		QueenSet queen = new QueenSet();
		
		for(int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		
		while(boardOpen(board)) {
			placeNextQueen(board, queen, 0, 0);
			markBoard(board, queen);
		}
		
		printBoard(board);
		while(queen.queenAvailable()) {
			int qNum = queen.getLastQueen();
			if (queen.qRow[qNum] == SIZE - 1 &&
					queen.qCol[qNum] == SIZE - 1) {
				queen.removeLastQueen();
			}
			qNum = queen.getLastQueen();
			int qRow = queen.qRow[qNum];
			int qCol = queen.qCol[qNum] + 1;
			
			queen.removeLastQueen();
			markBoard(board, queen);
			printBoard(board);
			while (boardOpen(board)) {
				if (!placeNextQueen(board, queen, qRow, qCol)) {
					qNum = queen.getLastQueen();
					if (queen.qRow[qNum] == SIZE - 1 &&
							queen.qCol[qNum] == SIZE - 1) {
						queen.removeLastQueen();
						markBoard(board, queen);
						printBoard(board);
					}
					qNum = queen.getLastQueen();
					qRow = queen.qRow[qNum];
					qCol = queen.qCol[qNum] + 1;
					
					queen.removeLastQueen();
				}
				markBoard(board, queen);
				printBoard(board);
			}
		}
		
		System.out.println("Game Complete");
		
	}
	
	// begins to try to place queen at a starting row and col
	public static boolean placeNextQueen(char[][] board, QueenSet queen, int row, int col) {
		int qNum = queen.getLastQueen() + 1;
		// finish incoming row
		for (; col < SIZE; ++col) {
			if (board[row][col] == ' ') {
				board[row][col] = (char)(qNum + 48);
				queen.placeQueen(row, col);
				return true;
			}
		}
		++row;
		
		// continue to (7, 7)
		for (; row < SIZE; ++row) {
			for (col = 0; col < SIZE; ++col) {
				if (board[row][col] == ' ') {
					board[row][col] = (char)(qNum + 48);
					queen.placeQueen(row, col);
					return true;
				}
			}
		}
		return false;
	}
	
	// markBoard must be performed before every board dependent function
	public static void markBoard(char[][] board, QueenSet queen) {
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		
		for (int qNum = queen.getLastQueen(); qNum >= 0; --qNum) {
			int row = queen.qRow[qNum];
			int col = queen.qCol[qNum];
			board[row][col] = (char)(qNum + 48);
			
			for (int radius = 1; radius < SIZE; ++radius) {
				for (int direction = 0; direction < 8; ++direction) {
					if (validMove(row, col, radius, direction) &&
							squareOpen(board, row, col, radius, direction)) {
						board[modRow(row, radius, direction)]
								[modCol(col, radius, direction)] = '#';
					}
				}
			}
		}
	}
	
	public static boolean validMove(int row, int col, int radius, int direction) {
		switch (direction) {
		
		// northeast, southeast, southwest, northwest
		case 0:
			if (row - radius >= 0 && col + radius < SIZE) {
				return true;
			}
			break;
		case 2:
			if (row + radius < SIZE && col + radius < SIZE) {
				return true;
			}
			break;
		case 4:
			if (row + radius < SIZE && col - radius >= 0) {
				return true;
			}
			break;
		case 6:
			if (row - radius >= 0 && col - radius >= 0) {
				return true;
			}
			break;
		
		// east, south, west, north
		case 1:

			if (col + radius < SIZE) {
				return true;
			}
			break;
		case 3:
			if (row + radius < SIZE) {
				return true;
			}
			break;
		case 5:
			if (col - radius >= 0) {
				return true;
			}
			break;
		case 7:
			if (row - radius >= 0) {
				return true;
			}
		}
		return false;
	}
	
	// returns true if the square is not attacked
	public static boolean squareOpen(char[][] board, int row, int col, int radius, int direction) {
		switch (direction) {
		
		// northeast, southeast, southwest, northwest
		case 0:
			if (board[row - radius][col + radius] == ' ') {
				return true;
			}
			break;
		case 2:
			if (board[row + radius][col + radius] == ' ') {
				return true;
			}
			break;
		case 4:
			if (board[row + radius][col - radius] == ' ') {
				return true;
			}
			break;
		case 6:
			if (board[row - radius][col - radius] == ' ') {
				return true;
			}
			break;
			
		// east, south, west, north
		case 1:
			if (board[row][col + radius] == ' ') {
				return true;
			}
			break;
		case 3:
			if (board[row + radius][col] == ' ') {
				return true;
			}
			break;
		case 5:
			if (board[row][col - radius] == ' ') {
				return true;
			}
			break;
		case 7:
			if (board[row - radius][col] == ' ') {
				return true;
			}
		}
		return false;
	}
	
	// returns a row in radius direction
	public static int modRow(int row, int radius, int direction) {
		switch (direction) {
		case 2:
		case 3:
		case 4:
			return row + radius;
		case 6:
		case 7:
		case 0:
			return row - radius;
		default:
			return row;
		}
	}
	
	// returns a col in radius direction
	public static int modCol(int col, int radius, int direction) {
		switch (direction) {
		case 0:
		case 1:
		case 2:
			return col + radius;
		case 4:
		case 5:
		case 6:
			return col - radius;
		default:
			return col;
		}
	}
	
	public static boolean boardOpen(char[][] board) {
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				if (board[row][col] == ' ') {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void printBoard(char[][] board) {
		for(int row = -1; row < SIZE + 1; ++row) {
			for(int col = -1; col < SIZE + 1; ++col) {
				if (row == -1 || row == SIZE) {
					System.out.printf("%c ", '-');
				}
				else if (col == -1 || col == SIZE) {
					System.out.printf("%c ", '|');
				}
				else {
					System.out.printf("%c ", board[row][col]);
				}
			}
			System.out.println();
		}
	}
}