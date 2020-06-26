import java.util.Scanner;

public class Memory{
	private static final Scanner input = new Scanner(System.in);
	private static final int SIZE = 100;
	
	private Register[] memory = new Register[SIZE];
	private int accumulator;
	private int instructionCounter;
	
	public Memory() {
		for (int i = 0; i < SIZE; ++i) {
			memory[i] = new Register();
		}
		
		this.accumulator = 0;
		this.instructionCounter = 0;
	}
	
	public void setAcc(int acc) {
		this.accumulator = acc;
	}
	public void setInsCount(int insCount) {
		this.instructionCounter = insCount;
	}
	
	public int getAcc() {
		return this.accumulator;
	}
	public int getInsCount() {
		return this.instructionCounter;
	}
	
	public void loadByScanner() {
		for (int i = 0; i < memory.length; ++i) {
			System.out.printf("%02d ? ", i);
			int in = input.nextInt();
			while ((in <= SIZE * -100 || in >= SIZE * 100) && in != -99999) {
				System.out.println("Invalid Entry.  Try again.");
				System.out.printf("%02d ? ", i);
			}
			if (in == -99999) {
				System.out.printf("*** %25s***%n", "Program loading completed");
				System.out.printf("*** %25s***%n", "Program execution begins");
				return;
			}
			memory[i].setRegister(in);
		}
		System.out.printf("*** %35s***%n", "Memory full");
		System.out.printf("*** %35s***%n", "Program loading completed");
		System.out.printf("*** %35s***%n", "Program execution begins");
	}
	
	void execute() {
		for (instructionCounter = 0; memory[instructionCounter].getOpCode() != 43; ++instructionCounter) {
			int operand = memory[instructionCounter].getOperand();
			switch (memory[instructionCounter].getOpCode()) {
			case 10:
				System.out.print("Input: ");
				memory[operand].setRegister(input.nextInt());
				break;
			case 11:
				System.out.print("Output: ");
				System.out.println(memory[operand].getRegister());
				break;
			case 20:
				accumulator = memory[operand].getRegister();
				break;
			case 21:
				memory[operand].setRegister(accumulator);
				break;
			case 30:
				accumulator += memory[operand].getRegister();
				if (accumulator >= SIZE * 100 || accumulator <= SIZE * -100) {
					System.out.println("*** Accumulator Overflow ****");
					System.out.println("*** Simpletron execution abnormally terminated ***");
					dump();
					return;
				}
				break;
			case 31:
				accumulator -= memory[operand].getRegister();
				if (accumulator >= SIZE * 100 || accumulator <= SIZE * -100) {
					System.out.println("*** Accumulator Overflow ****");
					System.out.println("*** Simpletron execution abnormally terminated ***");
					dump();
					return;
				}
				break;
			case 32:
				if (accumulator >= SIZE * 100 || accumulator <= SIZE * -100) {
					System.out.println("*** Attempt to divide by zero ***");
					System.out.println("*** Simpletron execution abnormally terminated ***");
					dump();
					return;
				}
				accumulator /= memory[operand].getRegister();
				if (accumulator >= SIZE * 100 || accumulator <= SIZE * -100) {
					System.out.println("*** Accumulator Overflow ****");
					System.out.println("*** Simpletron execution abnormally terminated ***");
					dump();
					return;
				}
				break;
			case 33:
				accumulator *= memory[operand].getRegister();
				if (accumulator >= SIZE * 100 || accumulator <= SIZE * -100) {
					System.out.println("*** Accumulator Overflow ****");
					System.out.println("*** Simpletron execution abnormally terminated ***");
					dump();
					return;
				}
				break;
			case 40:
				instructionCounter = operand - 1;
				break;
			case 41:
				if (accumulator < 0) {
					instructionCounter = operand - 1;
				}
				break;
			case 42:
				if (accumulator == 0) {
					instructionCounter = operand - 1;
				}
				break;
			default:
				System.out.println("*** Invalid operation code ***");
				System.out.println("*** Simpletron execution abnormally terminated ***");
				dump();
				return;
			}
			if (instructionCounter == SIZE - 1) {
				System.out.println("*** Memory Exceeded ***");
				System.out.println("*** Check Loop Code ***");
				System.out.println("*** Simpletron execution abnormally terminated ***");
				dump();
				return;
			}
		}
	}
	
	public void dump() {
		int i = this.instructionCounter;
		System.out.println("REGISTERS:");
		System.out.printf("%-21s%+05d%n", "accumulator", accumulator);
		System.out.printf("%-21s   %02d%n", "instructionCounter", i);
		System.out.printf("%-21s%+05d%n", "instructionRegister", memory[i].getRegister());
		System.out.printf("%-21s   %02d%n", "operationCode", memory[i].getOpCode());
		System.out.printf("%-21s   %02d%n%n", "operand", memory[i].getOperand());
		System.out.println("MEMORY:");
		System.out.printf("%2s", " ");
		for (int col = 0; col < 10; ++col) {
			System.out.printf("%6d", col);
		}
		System.out.println();
		for (int row = 0; row < SIZE; row += 10) {
			System.out.printf("%2d ", row);
			for (int col = 0; col < 10; ++col) {
				System.out.printf("%+05d ", memory[row + col].getRegister());
			}
			System.out.println();
		}
	}
}