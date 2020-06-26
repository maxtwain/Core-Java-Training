/*
 * Another puzzler for chess buffs is the Eight Queens problem, which asks the following: Is it possible to place eight queens on an empty chessboard so that no queen is "attacking" any other (no two queens are in the same row, in the same column, or along the same diagonal)?  Use the thinking developed in Exercise 7.22 to formulate a heuristic for solving the Eight Queens problem.  Run your application [Hint: It's possible to assign a value to each square of the chessboard to indicate how many squares of an empty chessboard are "eliminated" if a queen is placed in that square.  Each of the corners would be assigned the value 22, as demonstrated by Fig 7.31.  Once these "elimination numbers" are placed in all 64 squares, an appropriate heuristic might be as follows: Place the next queen in the square with the smallest elimination number.  Why is this strategy intuitively appealing?]
 */
import java.util.Arrays;

public class EightQueenHeur{
	public static final int SIZE = 8;
	
	public static void main(String[] args) {
		// board marks safe squares, attacked squares, and queen positions.
		char[][] board = new char[SIZE][SIZE];
		// heur marks number of squares attack from every position
		int[][] heur = new int[SIZE][SIZE];
		QueenSet queen = new QueenSet();
		
		for(int row = 0; row < SIZE; ++row) {
			Arrays.fill(board[row], ' ');
		}
		
		while(queen.queenAvailable() && boardOpen(board)) {
			generateHeur(board, heur);
			printBoard(board);
			printHeur(heur);
			placeNextQueen(heur, queen);
			markNewQueen(board, queen);
		}
		
		System.out.println("Game Complete");
		generateHeur(board, heur);
		printBoard(board);
		printHeur(heur);
	}
	
	public static void generateHeur(char[][] board, int[][] heur) {
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				if (board[row][col] == ' ') {
					heur[row][col] = sumAttacks(board, heur, row, col);
				}
				else {
					heur[row][col] = 99;
				}
			}
		}
	}
	
	public static int sumAttacks(char[][] board, int[][] heur, int row, int col) {
		// count landing square, so sum begins at 1.
		int sum = 1;
		for (int radius = 1; radius < SIZE; ++radius) {
			for (int direction = 0; direction < 8; ++direction) {
				if (validMove(row, col, radius, direction) &&
						squareOpen(board, row, col, radius, direction)) {
					++sum;
					}
				}
		}
		return sum;
	}
	
	// returns true if square is within the board area
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
	
	public static void placeNextQueen(int[][] heur, QueenSet queen) {
		int min = 99;
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				if (min > heur[row][col]) {
					min = heur[row][col];
				}
			}
		}
		
		for (int row = 0; row < SIZE; ++row) {
			for (int col = 0; col < SIZE; ++col) {
				if (min == heur[row][col]) {
					queen.placeQueen(row, col);
					return;
				}
			}
		}
	}
	
	// marks landing and attack squares on the board
	public static void markNewQueen(char[][] board, QueenSet queen) {
		int qNum = queen.getLastQueen();
		int row = queen.qRow[qNum];
		int col = queen.qCol[qNum];
		board[row][col] = 'Q';
		
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
	
	public static void printHeur(int[][] heur) {
		for(int row = -1; row < SIZE + 1; ++row) {
			for(int col = -1; col < SIZE + 1; ++col) {
				if (row == -1 || row == SIZE) {
					System.out.printf("%3s", "---");
				}
				else if (col == -1 || col == SIZE) {
					System.out.printf("%c ", '|');
				}
				else {
					System.out.printf("%3d ", heur[row][col]);
				}
			}
			System.out.println();
		}
	}
}