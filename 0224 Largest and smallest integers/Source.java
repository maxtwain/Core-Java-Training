/*
 *Write an application that reads five integers and determines and prints the largest and 
 *smallest integers in the group.  Use only the programming techniques you learned in this chapter.  
*/

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer: ");
		int num0 = input.nextInt();
		System.out.print("Enter the second integer: ");
		int num1 = input.nextInt();
		System.out.print("Enter the third integer: ");
		int num2 = input.nextInt();
		System.out.print("Enter the fourth integer: ");
		int num3 = input.nextInt();
		System.out.print("Enter the fifth integer: ");
		int num4 = input.nextInt();
		
		int largest = num0;
		int smallest = num0;
		
		if(largest < num1) {
			largest = num1;
		}
		if(smallest > num1) {
			smallest = num1;
		}
		
		if(largest < num2) {
			largest = num2;
		}
		if(smallest > num2) {
			smallest = num2;
		}
		
		if(largest < num3) {
			largest = num3;
		}
		if(smallest > num3) {
			smallest = num3;
		}
		
		if(largest < num4) {
			largest = num4;
		}
		if(smallest > num4) {
			smallest = num4;
		}
		
		System.out.printf("largest = %d%nsmallest = %d%n", largest, smallest);
	}
}