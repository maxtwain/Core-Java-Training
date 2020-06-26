import java.util.Scanner;

public class Exercises{
	public static void main(String[] args) {
		// A) Initialize integer variables
		int c = 0;
		int thisIsAVariable = 0;
		int q76354 = 0;
		int number = 0;
		
		Scanner input = new Scanner(System.in);
		
		// B) Prompt for integer entry
		System.out.print("Enter an integer: ");
		
		// C) Input integer
		int value = input.nextInt();
		
		// D) Print
		System.out.println("This is a Java program");
		
		// E) Print
		System.out.printf("%s%n%s",  "This is a Java ", "program");
		
		// F) Conditional
		if(number != 7) {
			System.out.println("The variable number is not equal to 7");
		}
	}
}