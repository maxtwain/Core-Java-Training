import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		// A) Comment
		// A program will calculate the product of three integers.
		
		// B) Create a Scanner called input that reads values from the standard input.
		Scanner input = new Scanner(System.in);
		
		// C) Prompt the user to enter the first integer.
		System.out.print("Enter the first integer: ");
		
		// D) Read the first integer from the user and store it in the variable x
		int x = input.nextInt();
		
		// E) Prompt the user to enter the second integer.
		System.out.print("Enter the second integer: ");
		
		// F) Read the second integer from the user and store it in the int variable y.
		int y = input.nextInt();
		
		// G) Prompt the user to enter the third integer.
		System.out.print("Enter the third integer: ");
		
		// H) Read the third integer from the user and store it in the int variable z
		int z = input.nextInt();
		
		// I) Compute the product of the three integers contained in variables x, y, 
		//and z, and store the result in the int variable result.
		int result = x * y * z;
		
		// J) Use System.out.printf to display the message "Product is" followed 
		//by the value of the variable result.
		System.out.printf("Product is %d.", result);
	}
}