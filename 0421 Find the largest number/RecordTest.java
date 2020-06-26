/*
 * Write a pseudocode program, then a Java application 
 * that inputs a series of 10 integers and determines 
 * and prints the largest integer.  Your program should 
 * use at least the following three variables:
 * 
 * A) counter: A counter to count to 10 (to keep track 
 * of how many numbers have been input and to 
 * determine when all 10 numbers have been processed).
 * 
 * B) number: The integer most recently input by the user
 * 
 * C) largest: The largest number found so far.
 */
import java.util.Scanner;

public class RecordTest{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		Record set0 = new Record(num);
		while(set0.getCounter() < 10) {
			set0.nextInt(input.nextInt());
		}
		System.out.printf("largest number: %d%n", set0.getLarInt());
	}
}