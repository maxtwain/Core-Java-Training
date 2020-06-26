/*
 * Write a program demonstrating that the order of catch blocks is important.  If you try to catch a superclass exception type before a subclass type, the compiler should generate errors.
 */

public class ExceptionTest{
	public static void main(String[] args) {
		try {
			throw new ExceptionA();
		} catch (ExceptionB e) {
			System.out.println("Exception B");
		} catch (ExceptionA e) {
			System.out.println("Exception A");
		}
	}
}