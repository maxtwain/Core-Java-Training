// Write an application that inputs three integers from the user and displays the sum, average, 
// product, smallest, and largest of the numbers.  Use the techniques shows in Fig. 2.15. 
// [Notes: The calculation of the average in this exercise should result in an integer 
// representation of the average.  So, if the sum of the values is 7, the average should be 2, 
// not 2.3333....]

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input first integer: ");
		int num0 = input.nextInt();
		System.out.print("Input second integer: ");
		int num1 = input.nextInt();
		System.out.print("Input third integer: ");
		int num2 = input.nextInt();
		
		System.out.printf("sum = %d%naverage = %d%nproduct = %d%n", 
				num0 + num1 + num2, (num0 + num1 + num2) / 3, num0 * num1 * num2);
		
		int smallest = num0;
		int largest = num0;
		if (num0 > num1) {
			smallest = num1;
		}
		else {
			largest = num1;
		}
		if (smallest > num2) {
			smallest = num2;
		}
		if(largest < num2) {
			largest = num2;
		}
		
		System.out.printf("smallest = %d%nlargest = %d%n",  smallest, largest);
	}
}
