/*
 * An integer number is said to be a perfect number if its factors, including
 *  1 (but not the number itself), sum to the number.  For example, 6 is a 
 *  perfect number, because 6 = 1 + 2 + 3.  Write a method isPerfect that 
 *  determines whether parameter number is a perfect number.  Use this method 
 *  in an application that displays all the perfect numbers between 1 and 1000.  
 *  Display the factors of each perfect number to confirm that the number is 
 *  indeed perfect.  Challenge the computing power of your computer by testing 
 *  number much larger than 1000.  Display the results.
 * 
 */

public class Perfect {
	public static void main(String[] args) {
		
		System.out.printf("%7s  %s%n", "Perfect", "Factors");
		for(int i = 2; i <= 1000; ++i) {
			if (isPerfect(i)) {
				System.out.printf("%4d%4s", i, " ");
				printFactors(i);
				System.out.println();
			}
		}
		/*
		if(isPerfect(28)) {
			System.out.print("yes");
		}
		else {
			System.out.print("no");
		}*/
	}
	
	public static boolean isPerfect(int num) {
		int sum = 1;
		for (int div = 2; num / 2 >= div; ++div) {
			if (num % div == 0) {
				sum += div;
			}
		}
		return sum == num;
	}
	
	public static void printFactors(int num) {
		System.out.printf("%5d", 1);
		for (int div = 2; num / 2 >= div; ++div) {
			if (num % div == 0) {
				System.out.printf(",%5d", div);
			}
		}
	}
}