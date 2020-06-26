/*
 * In Exercise 7.37, you wrote a software simulation of a computer that executes programs written in Simpletron Machine Language (SML).  In this exercise, we propose several modifications and enhancements to the Simpletron Simulator.  In the exercises of Chapter 21, we propose building a compiler that converts programs written in a high level programming language (a variation of Basic) to Simpletron Machine Language.  Some of the following modifications and enhancements may be required to execute the programs produced by the compiler.
 * 
 * A) Extend the Simpletron Simulator's memory to contain 1,000 memory locations to enable the Simpletron to handle larger programs.
 * 
 * B) Allow the simulator to perform remainder calculations.  This modification requires an additional SML instruction.
 * 
 * C) Allow the simulator to perform exponential calculations.  This modification requires an additional SML instruction.
 * 
 * D) Modify the simulator to use hexadecimal rather than integer values to represent SML instructions.
 * 
 * E) Modify the simulator to allow output of a newline.  This modification requires an additional SML instruction.
 * 
 * F) Modify the simulator to process floating point values in addition to integer values.
 * 
 * G) Modify the simulator to handle string input.  [Hint: Each Simpletron word can be divided into two groups, each holding a two digit integer.  Each two digit integer represents the ASCII (see Appendix B) decimal equivalent of a character.  Add a machine language instruction that will input a string and store the strong, beginning at a specific Simpletron memory location.  The first half of the word at that location will be a count of the number of characters in the string (the length of the string).  Each succeeding half word contains one ASCII character expressed as two decimal digits.  The machine language instruction converts each character into its ASCII equivalent and assigns it to a half word.]
 * 
 * H) Modify the simulator to handle output of strings stored in the format of part (g).  [Hint: Add a machine language instruction that will display a string, beginning at a certain Simpletron memory location.  The first half of the word at that location is a count of the number of characters in the string (the length of the strong).  Each succeeding half word contains one ASCII character expressed as two decimal digits.  The machine language instruction checks the length and displays the string by translating each two digit number into its equivalent character.]
 * 
 * 
 * 
 * My thoughts:  There doesn't seem to be any reason to change from decimal to hex.  I worry that this will just make the program more difficult to modify in later exercises, so for now I will forgo this.
 * I don't really understand how I might incorporate floating point values.  It feels like that would also make the program far too complex.  I've previously worked with a C algorithm that simulated IEEE 754 floating point.  That alone took a week or so.
 * For the rest of this, I just want to move on to the next lessons.  I learned some good things, but most of what I learned in this chapter had little to do with Arrays and ArrayLists, which was the chapter topic.  I feel I would get better at the parts of Java I need to practice with if I learned the things I need to learn in chapters which focused on them.
 */
import java.util.Scanner;

public class Simpletron{
	static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		printIntro();
		
		Memory memory = new Memory();
//		memory.loadByScanner();
//		memory.execute();
		memory.dump();
		
	}
	
	static void printIntro() {
		System.out.println("*** Welcome to Simpletron! ***"); 
		System.out.printf("*** %-45s***%n", "Please enter your program one instruction");
		System.out.printf("*** %-45s***%n", "(or data word) at a time.  I will display");
		System.out.printf("*** %-45s***%n", "the location number and a question mark (?).");
		System.out.printf("*** %-45s***%n", "You then type the word for that location.");
		System.out.printf("*** %-45s***%n%n", "Type -99999 to stop entering your program.");
	}
	
	
}