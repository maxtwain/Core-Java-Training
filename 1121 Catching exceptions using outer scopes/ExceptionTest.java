/*
 * Write a program showing that a method with its own try block does not have to catch every possible error generated within the try.  Some exceptions can slip through to, and be handled in, other scopes.
 * 
 * 
 * 
 * My notes:
 * This doesn't really work in the way I read the instructions.  I could move the method call into main's try block, and it would work, but that doesn't seem like it would adhere to the instructions of the exercise.
 */

public class ExceptionTest{
	public static void main(String[] args) {
		someMethod();
		
		try {
			
		} catch (IllegalArgumentException i) {
			System.out.println("Illegal catch");
		}
	}
	
	public static void someMethod() {
		try {
			throw new IllegalArgumentException();
		} catch (ArithmeticException a) {
			System.out.println("Arithmetic catch");
		}
	}
}