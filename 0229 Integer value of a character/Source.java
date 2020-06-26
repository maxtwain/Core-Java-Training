/*
Write an application that displays the integer equivalents of some uppercase letters, lowercase 
letters, digits, and special symbols.  Display the integer equivalents of the following: 
A B C a b c 0 1 2 $ * + / and the blank character.

Is the blank character a space or NULL?  I do not believe ASCII has a blank character.
*/

public class Source {
	public static void main(String[] args) {
		char c00 = 'A';
		char c01 = 'B';
		char c02 = 'C';
		char c03 = 'a';
		char c04 = 'b';
		char c05 = 'c';
		char c06 = '0';
		char c07 = '1';
		char c08 = '2';
		char c09 = '$';
		char c10 = '*';
		char c11 = '+';
		char c12 = '/';
		char c13 = ' ';
		
		System.out.printf("%c = %d%n", (int)c00, (int)c00);
		System.out.printf("%c = %d%n", (int)c01, (int)c01);
		System.out.printf("%c = %d%n", (int)c02, (int)c02);
		System.out.printf("%c = %d%n", (int)c03, (int)c03);
		System.out.printf("%c = %d%n", (int)c04, (int)c04);
		System.out.printf("%c = %d%n", (int)c05, (int)c05);
		System.out.printf("%c = %d%n", (int)c06, (int)c06);
		System.out.printf("%c = %d%n", (int)c07, (int)c07);
		System.out.printf("%c = %d%n", (int)c08, (int)c08);
		System.out.printf("%c = %d%n", (int)c09, (int)c09);
		System.out.printf("%c = %d%n", (int)c10, (int)c10);
		System.out.printf("%c = %d%n", (int)c11, (int)c11);
		System.out.printf("%c = %d%n", (int)c12, (int)c12);
		System.out.printf("%c = %d%n", (int)c13, (int)c13);
		
	}
}