/*
 * The Logo language made the concept of turtle graphics famous.  Imagine a mechanical turtle that walks around the room under the control of a Java application.  The turtle holds a pen in one of two positions, up or down.  While the pen is down, the turtle traces out shapes as it moves, and while the pen is up, the turtle moves about freely without writing anything.  In this problem, you'll simulate the operation of the turtle and create a computerized sketch pad.
 * Use a 20 by 20 array floor that's initialized to zeros.  Read commands from an array that contains them.  Keep track of the current position of the turtle at all times and whether the pen is currently up or down.  Assume that the turtle always starts at position (0, 0) of the floor with its pen up.  The set of commands your application must process are shown in Fig. 7.29.
 * 
 * 1	Pen up
 * 2	Pen down
 * 3	Turn right
 * 4	Turn left
 * 5, 10 Move forward 10 spaces (replace 10 for a different number of spaces)
 * 6	Display the 20 by 20 array
 * 9	End of data (sentinel)
 * 
 * Suppose that the turtle is somewhere near the center of the floor.  The following program would draw and display a 12 by 12 square, leaving the pen in the up position
 * 
 * 2
 * 5, 12
 * 3
 * 5, 12
 * 3
 * 5, 12
 * 3
 * 5, 12
 * 1
 * 6
 * 9
 * 
 * As the turtle moves with the pen down, set the appropriate elements of array floor to 1's.  When the 6 command (display the array) is given, wherever there's a 1 in the array, display an asterisk or any character you choose.  Wherever there's a 0, display a blank.
 * Write an application to implement the turtle graphics capabilities discussed here.  Write several turtle graphics programs to draw interesting shapes.  Add other commands to increase the power of your turtle graphics language.
 * 
 * 
 * 
 * This program requires me to be able to parse a line of input with multiple delimiters, which is a subject for a future chapter in the book.  It is examples like this that cause me to complain about the way the book is lain out.  If the book is supposed to be teaching me how to use java, you'd think that it would present the material before asking me use it.
 * Rather than learn regex, split, StringTokenizer, and such, I am just going to skip this problem and do these as they appear in the book.
 */
import java.util.Scanner;

public class TurtleGraphics{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Turtle turtle = new Turtle();
		
		int mag;
		System.out.print("? ");
		switch (input.nextInt()) {
		case 1:
			turtle.setPenDown(true);
			break;
		case 2:
			turtle.setPenDown(false);
			break;
		case 3:
			switch (turtle.getDir()) {
			case NORTH:
				turtle.setDir(Direction.EAST);
				break;
			case EAST:
				turtle.setDir(Direction.SOUTH);
				break;
			case SOUTH:
				turtle.setDir(Direction.WEST);
				break;
			case WEST:
				turtle.setDir(Direction.NORTH);
			}
			break;
		case 4:
			switch (turtle.getDir()) {
			case NORTH:
				turtle.setDir(Direction.WEST);
				break;
			case EAST:
				turtle.setDir(Direction.NORTH);
				break;
			case SOUTH:
				turtle.setDir(Direction.EAST);
				break;
			case WEST:
				turtle.setDir(Direction.SOUTH);
			}
			break;
		case 5:
			mag = input.nextInt();
			switch (turtle.getDir()) {
			case NORTH:
				turtle.setRow(-1 * input.nextInt());
				break;
			case EAST:
				turtle.setCol(
			}
		}
	}
	
	
}