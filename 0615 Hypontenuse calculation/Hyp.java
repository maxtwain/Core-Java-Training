/*
 * Define a method hypotenuse that calculates the hypotenuse 
 * of a right triangle when the lengths of the other two 
 * sides are given.  The method should take two arguments of 
 * type double and return the hypotenuse as a double.  
 * Incorporate this method into an application that reads 
 * values for a side1 and side2 and performs the calculation 
 * with the hypotenuse method.  Use math methods pow and sqrt 
 * to determine the length of the hyponenuse for each of the 
 * triangles in Fig 6.14.
 * 
 * Triangle		Side 1		Side2
 * 1			3.0			4.0
 * 2			5.0			12.0
 * 3			8.0			15.0
 */

public class Hyp{
	public static void main(String[] args) {
		System.out.printf("Hypontenuse of triangle 1 = %f%n", hyp(3, 4));
		System.out.printf("Hypontenuse of triangle 2 = %f%n", hyp(5, 12));
		System.out.printf("Hypontenuse of triangle 3 = %f%n", hyp(8, 15));
	}
	
	// c * c == a * a + b * b
	// c = sqrt(a * a + b * b)
	public static double hyp(double side1, double side2) {
		return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
	}
}