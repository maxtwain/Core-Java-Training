/*
 * The Java compiler always associates an else with 
 * the immediately preceding if unless told to do 
 * otherwise by the placement of braces.  This 
 * behavior can lead to what is referred to as the 
 * dangling else problem.  The indentation of the 
 * nested statement
 * 
 * if (x > 5)
 * 	if (y > 5)
 * 		System.out.println("x and y are > 5");
 * 
 * else
 * 	System.out.println("x is <= 5);
 * 
 * appears to indicate that if x is greater than 5, 
 * the nested if statement determines whether y is 
 * also greater than 5.  If so, the statement 
 * outputs the string "x and y are > 5".  Otherwise 
 * it appears that if x is not greater than 5, the 
 * else part of the if...else outputs the string 
 * "x is <= 5".  Beware!  This nested if...else 
 * statement does not execute as it appears.  The 
 * compiler actually interprets the statement as
 * 
 * if (x > 5)
 * 	if (y > 5)
 * 		System.out.println("x and y are > 5");
 * else
 * 	System.out.println("x is <= 5);
 * 
 * in which the body of the first if is a nested 
 * if...else.  The outer if statement tests whether 
 * x is greater than 5.  If so, execution continues 
 * by testing whether y is also greater than 5.  If 
 * the second condition is true, the proper string - 
 * "x and y are > 5" - is displayed.  However if the 
 * second condition is false, the string "x is <= 5" 
 * is displayed, even though we know that x is 
 * greater than 5.  Equally bad, if the outer if 
 * statement's condition is false, the inner 
 * if...else is skipped and nothing is displayed.  
 * For this exercise, add braces to the preceding 
 * code snippet to force the nested if...else 
 * statement to execute as it was originally intended.
 */

public class Dang{
	public static void main(String[] args) {
		int x = 6;
		int y = 4;
		
		if (x > 5) {
			if (y > 5) {
				System.out.println("x and y are > 5");
			}
		}
		else {
			System.out.println("x is <= 5");
		}
		
	}
}