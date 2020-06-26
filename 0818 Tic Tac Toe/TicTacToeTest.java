/*
 * Create a class TicTacToe that will enable you to write a program to play Tic Tac Toe.  The class contains a private 3 by 3 two dimensional array.  Use an enum type to represent the value in each cell of the array.  The enum's constants should be named X, O, and EMPTY (for a positions that does not contain an X or an O).  The constructor should initialize the board elements to EMPTY.  Allow two human players.  Wherever the first player moves, place an X in the specified square, and place an O wherever the second player moves.  Each move must be to an empty square.  After each move, determine whether the game has been won and whether it's a draw.  If you feel ambitious, modify your program so that the computer makes the moves for one of the players.  Also, allow the player to specify whether he or she wants to go first or second.  If you feel exceptionally ambitions develop a program that will play 3 dimensional Tic Tac Toe on a 4 by 4 by 4 board [Note: This is an extremely challenging project!].
 */

public class TicTacToeTest{
	public static void main(String[] args) {
		TicTacToe board = new TicTacToe();
		
		while (board.checkWin() == TicTacToe.Cell.E) {
			board.print();
			board.xMovePrompt();
			if (board.checkWin() == TicTacToe.Cell.E) {
				board.print();
				board.oMovePrompt();
			}
		}
		
		if (board.checkWin() == TicTacToe.Cell.X) {
			System.out.println("X Wins");
		}
		else if (board.checkWin() == TicTacToe.Cell.O) {
			System.out.println("O Wins");
		}
		else {
			System.out.println("Cats Game");
		}
		board.print();
	}
}