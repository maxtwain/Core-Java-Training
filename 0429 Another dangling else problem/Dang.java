/*
 * Based on the dangling else discussion in Exercise 
 * 4.27, modify the following code to produce the 
 * output shown.  Use proper indentation techniques.  
 * You must not make any additional changes other 
 * than inserting braces and changing the code's 
 * indentation.  We've eliminated the indentation 
 * from the following code to make the problem more 
 * challenging.  [Note:  It's possible that no 
 * modification is necessary.]
 * 
 * if (y == 8)
 * if (x == 5)
 * System.out.println("@@@@@");
 * else
 * System.out.println("#####");
 * System.out.println("$$$$$");
 * System.out.println("&&&&&");
 * 
 * A) Assuming that x = 5 and y = 8, the following 
 * output is produced:
 * 
 * @@@@@
 * $$$$$
 * &&&&&
 * 
 * B) Assuming that x = 5 and y = 8, the following 
 * output is produced:
 * 
 * @@@@@
 * 
 * C) Assuming that x = 5 and y = 8, the following 
 * output is produced:
 * 
 * @@@@@
 * &&&&&
 * 
 * D) Assuming that x = 5 and y = 7, the following 
 * output is produced.  [Note: The last three output 
 * statements after the else are all part of a block.]
 * 
 * #####
 * $$$$$
 * &&&&&
 */

public class Dang{
	public static void main(String[] args) {
		int x;
		int y;
		
		// A)
		x = 5;
		y = 8;
		
		if (y == 8) {
			if (x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
		}
		System.out.println("$$$$$");
		System.out.println("&&&&&");
		
		System.out.println("");
		// B)
		x = 5;
		y = 8;
		
		if (y == 8) {
			if (x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
			System.out.println("$$$$$");
			System.out.println("&&&&&");
		}
		
		System.out.println("");
		// C)
		x = 5;
		y = 8;
		
		if (y == 8) {	
			if (x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
			System.out.println("$$$$$");
		}
		System.out.println("&&&&&");
		
		System.out.println("");
		// D)
		x = 5;
		y = 7;
		
		if (y == 8) {	
			if (x == 5) {
				System.out.println("@@@@@");
			}
		}
		else {
			System.out.println("#####");
			System.out.println("$$$$$");
			System.out.println("&&&&&");
		}
	}
}