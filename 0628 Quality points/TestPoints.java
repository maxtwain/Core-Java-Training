/*
 * Write a method qualityPoints that inputs a student's average 
 * and returns 4 if it's 90-100, 3 if 80-89, 2 if 70-79, 1 if 60-69, 
 * and 0 if lower than 60.  Incorporate the method into an application 
 * that reads a value from the user and displays the result.
 */
import java.util.Scanner;

public class TestPoints{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a test score: ");
		int score = input.nextInt();
		
		System.out.printf("%d quality points are awarded.%n", qualityPoints(score));
		
	}
	
	public static int qualityPoints(int average) {
		if (average >= 90) {
			return 4;
		}
		else if (average >= 80) {
			return 3;
		}
		else if (average >= 70) {
			return 2;
		}
		else if (average >= 60) {
			return 1;
		}
		else {
			return 0;
		}
	}
}