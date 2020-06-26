/*
 * Create a class called rational for performing arithmetic with fractions.  Write a program to test your class.  Use integer variables to represent the private instance variables of the class - the numerator and the denominator.  Provide a constructor that enables an object of this class to be initialized when it's declared.  The constructor should store the fraction in reduced form.  The fraction 2/4 is equivalent to 1/2 and would be stored in the object as 1 in the numerator and 2 in the denominator.  Provide a no argument constructor with default values in case no initializers are provided provide public methods that perform each of the following operations:
 * 
 * A) Add two Rational numbers: The result of the addition should be stored in reduced form.  Implement this as a static method.
 * 
 * B) Subtract two Rational numbers: The result of the subtraction should be stored in reduced form.  Implement this as a static method.
 * 
 * C) Multiply two Rational numbers: The result of the multiplication should be stored in reduced form.  Implement this as a static method.
 * 
 * D) Divide two Rational numbers:  The result of the division should be stored in reduced form.  Implement this as a static method.
 * 
 * E) Return a String representation of a Rational number in the form a/b, where a is the numerator and b is the denominator.
 * 
 * F) Return a String representation of a Rational number in floating point format.  (Consider providing formatting capabilities that enable the user of the class to specify the number of digits of precision to the right of the decimal point.)
 */

public class RationalTest{
	public static void main(String[] args) {
		Rational rat0 = new Rational(1, 6);
		Rational rat1 = new Rational(1, 10);
		Rational rat2 = new Rational();
		
		System.out.printf("rat0.toString() = %s%n", rat0.toString());
		System.out.printf("rat0.floatString(3) = %s%n", rat0.floatString(3));
		System.out.println();
		
		rat2 = Rational.add(rat0, rat1);
		System.out.printf("%s + %s = %s%n", rat0.toString(), rat1.toString(), rat2.toString());
		
		rat2 = Rational.subtract(rat0, rat1);
		System.out.printf("%s - %s = %s%n", rat0.toString(), rat1.toString(), rat2.toString());
		
		rat2 = Rational.multiply(rat0, rat1);
		System.out.printf("%s * %s = %s%n", rat0.toString(), rat1.toString(), rat2.toString());
		
		rat2 = Rational.divide(rat0, rat1);
		System.out.printf("%s / %s = %s%n", rat0.toString(), rat1.toString(), rat2.toString());
		
	}
}