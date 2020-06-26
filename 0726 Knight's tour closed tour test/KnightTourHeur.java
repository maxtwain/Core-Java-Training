/*
 * In the Knight's Tour (Exercise 7.22), a full tour occurs when the knight makes 64 moves, touching each square of the chessboard once and only once.  A closed tour occurs when the 64th move is one move away from the square in which the knight started the tour.  Modify the application you wrote in Exercise 7.22 to test for a closed tour if a full tour has occurred.
 * 
 * 
 * 
 * It would be a small thing to modify 7.22 code, and I have still yet to do a Knight's Tour Heuristic, so that is what I plan to do.  I'll do a closed tour as well.
 */
import java.util.Arrays;

public class KnightTourHeur{
	public static final int SIZE = 8;
	
	public static void main(String[] args) {
		char[][] board = new char[SIZE][SIZE];
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		int[][] heur = new int[SIZE][SIZE];
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(heur[row], 99);
		}
		Knight knight = new Knight(0, 0);
		
		while (boardOpen(board)) {
			generateHeur(board, heur, knight);
			moveKnight(board, heur, knight);
			printBoard(board);
		}
		System.out.println("Tour Complete.");
	}
	
	public static void moveKnight(char[][] board, int[][] heur, Knight knight) {
		board[knight.getRow()][knight.getCol()] = '#';
		int min = 99;
		for (int i = 0; i < 8; ++i) {
			int row = knight.kMoveRow[i];
			int col = knight.kMoveCol[i];
			if (row != -1 && col != -1 && board[row][col] == ' ' &&
					min > heur[row][col]) {
				min = heur[row][col];
			}
		}
		if (min == 99) {
			System.out.println("moveKnight failed.");
			return;
		}
		
		for (int i = 0; i < 8; ++i) {
			int row = knight.kMoveRow[i];
			int col = knight.kMoveCol[i];
			if (row != -1 && col != -1 && board[row][col] == ' ' &&
					min == heur[row][col]) {
				knight.setKPos(row, col);
				board[knight.getRow()][knight.getCol()] = 'K';
				return;
			}
		}
	}
	
	public static void generateHeur(char[][] board, int[][] heur, Knight knight) {
		for (int row = 0; row < SIZE; ++row) {
			Arrays.fill(heur[row], 99);
		}
		
		for (int i = 0; i < 8; ++i) {
			int row = knight.kMoveRow[i];
			int col = knight.kMoveCol[i];
			if (row != -1 && col != -1) {
				heur[row][col] = sumMoves(board, heur, row, col); 
			}
		}
	}
	
	public static int sumMoves(char[][] board, int[][] heur, int row, int col) {
		int sum = 0;
		for (int direction = 0; direction < 8; ++direction) {
			if (validMove(row, col, direction) &&
					squareOpen(board, row, col, direction)) {
				++sum;
			}
		}
		return sum;
	}
	
	// determines if move in direction is on the board.
	public static boolean validMove(int row, int col, int direction) {
		switch (direction) {
		case 0:
			if (row - 2 >= 0 && col + 1 < SIZE) {
				return true;
			}
			break;
		case 1:
			if (row - 1 >= 0 && col + 2 < SIZE) {
				return true;
			}
			break;
		case 2:
			if (row + 1 < SIZE && col + 2 < SIZE) {
				return true;
			}
			break;
		case 3:
			if (row + 2 < SIZE && col + 1 < SIZE) {
				return true;
			}
			break;
		case 4:
			if (row + 2 < SIZE && col - 1 >= 0) {
				return true;
			}
			break;
		case 5:
			if (row + 1 < SIZE && col - 2 >= 0) {
				return true;
			}
			break;
		case 6:
			if (row - 1 >= 0 && col - 2 >= 0) {
				return true;
			}
			break;
		case 7:
			if (row - 2 >= 0 && col - 1 >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean squareOpen(char[][] board, int row, int col, int direction) {
		switch (direction) {
		case 0:
			if (board[row - 2][col + 1] == ' ') {
				return true;
			}
			break;
		case 1:
			if (board[row - 1][col + 2] == ' ') {
				return true;
			}
			break;
		case 2:
			if (board[row + 1][col + 2] == ' ') {
				return true;
			}
			break;
		case 3:
			if (board[row + 2][col + 1] == ' ') {
				return true;
			}
			break;
		case 4:
			if (board[row + 2][col - 1] == ' ') {
				return true;
			}
			break;
		case 5:
			if (board[row + 1][col - 2] == ' ') {
				return true;
			}
			break;
		case 6:
			if (board[row - 1][col - 2] == ' ') {
				return true;
			}
			break;
		case 7:
			if (board[row - 2][col - 1] == ' ') {
				return true;
			}
		}
		return false;
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