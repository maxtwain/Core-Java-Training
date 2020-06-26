/*
 * A right triangle can have sides whose lengths 
 * are all integers.  The set of three integer 
 * values for the lengths of the sides of a 
 * right triangle is called a Pythagorean triple.  
 * The lengths of the three sides must satisfy 
 * the relationship that the sum of the squares 
 * of two of the sides is equal to the square of 
 * the hypotenuse.  Write an application that 
 * displays a table of the Pythagorean triples 
 * for side1, side2, and the hypotenuse, all no 
 * larger than 500.  Use a triple nested for 
 * loop that tries all possibilities.  This 
 * method is an example of brute force 
 * computing.  You'll learn in more advanced 
 * computer science sources that for many 
 * interesting problems there's no known 
 * algorithmic approach other than using 
 * sheer brute force.
 */

public class PyTrip{
	public static void main(String[] args) {
		System.out.printf("%5s%5s%5s%n", "hyp", "side1", "side2");
		
		for(int hyp = 2; hyp <= 500; ++hyp) {
			for(int side1 = 1; side1 < hyp; ++side1) {
				for(int side2 = 1; side2 <= side1; ++side2) {
					if(hyp * hyp == side1 * side1 + side2 * side2) {
						System.out.printf("%5d%5d%5d%n", hyp, side1, side2);
					}
				}
			}
		}
	}
}