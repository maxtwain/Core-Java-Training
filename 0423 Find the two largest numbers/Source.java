/*
 * Using an approach similar to that for Exercise 
 * 4.21, find the two largest values of the 10 
 * values entered.  [Note: You may input each 
 * number only once]
 */
import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		int num;
		int largest;
		int larger;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		num = input.nextInt();
		largest = num;
		
		System.out.print("Enter a number: ");
		num = input.nextInt();
		if(largest > num) {
			larger = num;
		}
		else {
			larger = largest;
			largest = num;
		}
		
		for(int count = 2; count < 10; ++count) {
			System.out.print("Enter a number: ");
			num = input.nextInt();
			if(num > larger) {
				if(num > largest) {
					larger = largest;
					largest = num;
				}
				else {
					larger = num;
				}
			}
		}
		
		System.out.printf("larger = %d%nlargest = %d%n", larger, largest);
	}
}