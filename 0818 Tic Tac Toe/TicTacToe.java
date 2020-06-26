import java.util.Scanner;

public class TicTacToe{
	private static final Scanner input = new Scanner(System.in);
	private static final int SIZE0 = 3;
	private static final int SIZE1 = 3;
	public enum Cell {E, X, O};
	
	private Cell[][] board;
	
	public TicTacToe() {
		board = new Cell[SIZE0][SIZE1];
		for (int row = 0; row < board.length; ++row) {
			for (int col = 0; col < board[row].length; ++col) {
				board[row][col] = Cell.E;
			}
		}
	}
	
	public void setCell(int row, int col, Cell status) {
		board[row][col] = status;
	}
	
	public void print() {
		int square = 0;
		for (int row = 0; row <= SIZE0 * 2; ++row) {
			for (int col = 0; col <= SIZE1 * 2; ++col) {
				if (row % 2 == 0) {
					System.out.print("-");
				}
				else if (col % 2 == 0) {
					System.out.print("|");
				}
				else {
					if (board[(row - 1) / 2][(col - 1) / 2] == Cell.E) {
						System.out.print(square);
					}
					else {
						System.out.print(board[(row - 1) / 2][(col - 1) / 2]);
					}
					++square;
				}
			}
			System.out.println();
		}
	}
	
	public void xMovePrompt() {
		System.out.print("Enter X move: ");
		int move = input.nextInt();
		int row = move / 3;
		int col = move % 3;
		
		board[row][col] = Cell.X;
	}
	
	public void oMovePrompt() {
		System.out.print("Enter O move: ");
		int move = input.nextInt();
		int row = move / 3;
		int col = move % 3;
		
		board[row][col] = Cell.O;
	}
	
	public Cell checkWin() {
		// checking X
		if ((board[0][0] == Cell.X && board[0][1] == Cell.X && board[0][2] == Cell.X) ||
			(board[1][0] == Cell.X && board[1][1] == Cell.X && board[1][2] == Cell.X) ||
			(board[2][0] == Cell.X && board[2][1] == Cell.X && board[2][2] == Cell.X) ||
			(board[0][0] == Cell.X && board[1][0] == Cell.X && board[2][0] == Cell.X) ||
			(board[0][1] == Cell.X && board[1][1] == Cell.X && board[2][1] == Cell.X) ||
			(board[0][2] == Cell.X && board[1][2] == Cell.X && board[2][2] == Cell.X) ||
			(board[0][0] == Cell.X && board[1][1] == Cell.X && board[2][2] == Cell.X) ||
			(board[0][2] == Cell.X && board[1][1] == Cell.X && board[2][0] == Cell.X)) {
			return Cell.X;
		}
		else if (
			(board[0][0] == Cell.O && board[0][1] == Cell.O && board[0][2] == Cell.O) ||
			(board[1][0] == Cell.O && board[1][1] == Cell.O && board[1][2] == Cell.O) ||
			(board[2][0] == Cell.O && board[2][1] == Cell.O && board[2][2] == Cell.O) ||
			(board[0][0] == Cell.O && board[1][0] == Cell.O && board[2][0] == Cell.O) ||
			(board[0][1] == Cell.O && board[1][1] == Cell.O && board[2][1] == Cell.O) ||
			(board[0][2] == Cell.O && board[1][2] == Cell.O && board[2][2] == Cell.O) ||
			(board[0][0] == Cell.O && board[1][1] == Cell.O && board[2][2] == Cell.O) ||
			(board[0][2] == Cell.O && board[1][1] == Cell.O && board[2][0] == Cell.O)) {
			return Cell.O;
		}
		return Cell.E;
	}
}