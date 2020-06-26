/*
 * Use inheritance to create an exception superclass (called ExceptionA) and exception subclasses ExcpetionB and ExceptionC, where ExceptionB inherits from ExceptionA and ExceptionC inherits from ExceptionB.  Write a program to demonstrate that the catch block for type ExceptionA catches exceptions of types ExceptionB and ExceptionC.
 * 
 * 
 * 
 * My notes:
 * I don't think I understand what these exercise instructions are trying to communicate.  I suspect it wants me to use this:
 * catch (type0 | type1 | type2)
 * but I don't see what inheritance has to do with that.
 */


public class ExceptionATest{
	public static void main(String[] args) {
		
		ExceptionA.throwException();
		ExceptionB.throwException();
		ExceptionC.throwException();
	}
}