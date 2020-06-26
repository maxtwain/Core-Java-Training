/*
 * Write an application that keeps displaying 
 * in the command window the multiples of the 
 * integer 2 - namely, 2, 4, 8, 16, 32, 64, 
 * and so on.  Your loop should not terminate 
 * (it should create an infinite loop).  What 
 * happens when you run this program?
 */

public class Twos{
	public static void main(String[] args) {
		for(int i = 2; i < 999999999; i *= 2) {
			System.out.printf("%d%n", i); 
		}
	}
}

// i overloads and becomes 0.  It then becomes 0 * 2 which is also 0.