/*
 * In this problem you're going to build your own computer.  No, you'll not be soldering components together.  Rather, you'll use the powerful technique of software based simulation to create an object oriented software model of the Simpletron of Exercise 7.36.  Your Simpletron simulator will turn the computer you're using into a Simpletron, and you'll actually be able to run, test, and debug the SML programs you wrote in Exercise 7.36.
 * When you run your Simpletron simulator, it should begin by displaying
 * 
 * *** Welcome to Simpletron! ***
 * *** Please enter your program one instruction	***
 * *** (or data word) at a time.  I will display	***
 * *** the location number and a question mark (?)	***
 * *** You then type the word for that location.	***
 * *** Type -99999 to stop entering your program.	***
 * 
 * Your application should simulate the memory of the Simpletron with a one dimensional array memory that has 100 elements.  Now assume that the simulator is running, and let's examine the dialog as we enter the program of Fig. 7.35 (Exercise 7.36):
 * 
 * 00 ? +1009
 * 01 ? +1010
 * 02 ? +2009
 * 03 ? +3110
 * 04 ? +4107
 * 05 ? +1109
 * 06 ? +4300
 * 07 ? +1110
 * 08 ? +4300
 * 09 ? +0000
 * 10 ? +0000
 * 11 ? -99999
 * 
 * Your program should display the memory location followed by a question mark.  Each value to the right of a question mark is input by the user.  When the sentinel value -99999 is input, the program should display the following:
 * 
 * *** Program loading completed	***
 * *** Program execution begins		***
 * 
 * The SML program has now been placed (or loaded) in array memory.  Now the Simpletron executes the SML program.  Execution begins with the instruction in location 00 and, as in Java, continues sequentially, unless directed to some other part of the program by a transfer of control.
 * Use the variable accumulator to represent the accumulator register.  Use the variable instructionCoutner to keep track of the location in memory that contains the instruction being performed.  Use the variable operationCode to indicate the operation currently being performed (the left two digits of the instruction word).  Use the variable operand to indicate the rightmost two digits of the instruction currently being performed.  Do not execute instructions directly from memory.  Rather, transfer the next instruction to be performed from memory to a variable called instructionRegiser.  Then pick off the left two digits and place the in operationCode, and pick off the right two digits and place them in operand.  When the Simpletron beings execution, the special registers are all initialized to zero.
 * 
 * Now, let's walk through execution of the first SML instruction, +1009 in memory location 00.  This procedure is called an instruction execution cycle.
 * The instructionCounter tells us the location of the next instruction to be performed.  We fetch the contents of that location from memory by using the Java statement
 * 
 * instructionRegister = memory[instructionCounter];
 * 
 * The operation code and the operand are extracted form the instruction register by the statements
 * 
 * operationCode = instructionRegister / 100;
 * operand = instructionRegister % 100;
 * 
 * Now the Simpletron must determine that the operation code is actually a read (versus a write, a load, and so on.)  A switch differentiates among the 12 operations of SML.  In the switch statement, the behavior of various SML instructions is simulated as shows in Fig 7.36.  We discuss branch instructions shortly and leave the others to you.
 * 
 * read:
 * 	Display the prompt "Enter an integer", then input the integer and store it in location memory[operand].
 * 
 * load:
 * 	accumulator = memory[operand];
 * 
 * add:
 * 	accumulator += memory[operand];
 * 
 * halt:
 * 	Terminate the SML program's execution and display the following message:
 * *** Simpletron execution terminated ***
 * 
 * When the SML program completes execution, the name and contents of each register as well as the complete contents of memory should be displayed.  Such a printout is often called a computer dump (no, a computer dump is not a place where old computers go).  To help you program your dump method, a sample dump format is shows in Fig 7.37.  A dump after executing a Simpletron program would show the actual values of instructions and data values at the moment execution terminated.
 * 
 * Let's proceed with the execution of our program's first instruction - namely, the +1009 in location 00.  As we've indicated, the switch statement simulates this task by prompting the user to enter a value, reading the value, and storing it in memory location memory[operand].  The value is then read into location 09.
 * At this point, simulation of the first instruction is completed.  All that remains is to prepare the Simpletron to execute the next instruction.  Since the instruction just performed was not a transfer of control, we need merely increment the instruction counter register as follows:
 * 
 * instructionCoutner++;
 * 
 * This action completes the simulated execution of the first instruction.  The entire process (the instruction execution cycle) begins anew with the fetch of the next instruction to execute.
 * Now let's consider how the branching instructions - the transfers of control - are simulated.  All we need to do is adjust the value in the instruction counter appropriately.  Therefore, the unconditional branch instruction (40) is simulated within the switch as 
 * 
 * instructionCounter = operand;
 * 
 * The conditional "branch if accumulator is zero" instruction is simulated as 
 * 
 * if (accumulator == 0) {
 * 		instructionCounter = operand;
 * }
 * 
 * At this point, you should implement your Simpletron simulator and run each of the SML programs you wrote in Exercise 7.36.  If you desire, you may embellish SML with additional features and provide for these features in your simulator.
 * Your simulator should check for various types of errors.  During the program loading phase, for example, each number the user types into the Simpletron's memory must be in the range -9999 to +9999.  Your simulator should test that each number entered is in this range and, if not, keep prompting the user to reenter the number until the user enters a correct number.
 * During the execution phase, your simulator should check for various serious errors, such as attempts to divide by zero, attempts to execute invalid operation codes, and accumulator overflows (arithmetic operations resulting in values larger than +999 or smaller than -999).  Such serious error are called fatal errors.  When a fatal error is detected, your simulator should display an error message, such as
 *
 * *** Attempt to divide by zero ***
 * *** Simpletron execution abnormally terminated	***
 * 
 * and should display a full computer dump in the format we discussed previously.  This treatment will help the user locate the error in the program.
 */
import java.util.Scanner;

public class Simpletron{
	static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		printIntro();
		
		Memory memory = new Memory();
		memory.loadByScanner();
		memory.execute();
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