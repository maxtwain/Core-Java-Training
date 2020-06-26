/*
 * Write a program that demonstrates how various exceptions are caught with catch (Exception exception).  This time, define classes ExceptionA(which inherits from class Exception), and ExceptionB (which inherits from class ExceptionA).  In your program, create try blocks that throw exceptions of types ExceptionA, ExceptionB, NullPointerException, and IOException.  All exceptions should be caught with catch blocks specifying type Exception.
 * 
 * 
 * 
 * My notes:
 * There is not any demonstration of Exception classes introduced in this chapter.  Figuring things out is fine when you've seen examples of how a thing is done, but this book doesn't always do this.  One of the problems with this particular exercise is that Exception classes inherit or implement the class Serializable.  I don't yet understand what this class is, but I believe it has an abstract function in it which means any children of Exception should also have this function.
 */

public class ExceptionTest{
	public static void main(String[] args) {
		try {
			throw new ExceptionA("Exception A");
		} catch (Exception e) {
			System.out.println("Exception A");
		}
		
		try {
			throw new ExceptionB("Exception B");
		} catch (Exception e) {
			System.out.println("Exception B");
		}
		
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			System.out.println("NullPointerException");
		}
		
		try {
			throw new java.io.IOException("IO exception");
		} catch (Exception e) {
			System.out.println("IOException");
		}
	}
}