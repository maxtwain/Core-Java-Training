/*
 * Modify the method created in Exercise 6.18 to receive a second parameter of type
 *  char called fillCharacter.  Form the square using the char provided as an argument.  
 *  Thus, if side is 5 and fillCharacter is #, the method should display:
 * 
 * Use the following statement (in which input is a Scanner object) to read a 
 * character from the user at the keyboard
 * 
 * char fill = input.next().charAt(0);
 */
import java.util.Scanner;

public class AnySquare {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter square size: ");
		int size = input.nextInt();
		System.out.print("Enter fill character: ");
		char fillCharacter = input.next().charAt(0);
		square(size, fillCharacter);
	}
	
	public static void square(int side, char fillCharacter) {
		for(int row = 0; row < side; ++row) {
			for(int col = 0; col < side; ++col) {
				System.out.printf("%c", fillCharacter);
			}
			System.out.println();
		}
	}
}