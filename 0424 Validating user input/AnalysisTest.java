/*
 * Modify the program in Fig. 4.12 to validate its 
 * inputs.  For any input, if the value entered is 
 * other than 1 or 2, keep looping until the user 
 * enters a correct value.
 */

import java.util.Scanner;

public class AnalysisTest{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int passes = 0;
		int failures = 0;
		for(int sCount = 1; sCount <= 10; ++sCount) {
			System.out.print("Enter result (1 = pass, 2 = fail): ");
			
			// I don't yet know java string handling, so this will
			// have to remain an int check.
			int result = input.nextInt();
			if (result == 1) {
				++passes;
			}
			else if (result == 2) {
				++failures;
			}
			else {
				System.out.println("Invalid entry.");
				--sCount;
			}
		}
		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
		
		if(passes > 8) {
			System.out.println("Bonus to instructor!");
		}
	}
}