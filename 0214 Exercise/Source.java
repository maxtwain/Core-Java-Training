// Write an application that displays the numbers 1 to 4 on the same line, with each pair of adjacent 
//numbers separated by one space.  Use the following techniques:

public class Source{
	public static void main(String[] args) {
		// A) one System.out.println statement
		System.out.println("1 2 3 4");
		
		// B) four System.out.print statements.
		System.out.print("1 ");
		System.out.print("2 ");
		System.out.print("3 ");
		System.out.print("4\n");
		
		// C) one System.out.printf statement
		System.out.printf("%s",  "1 2 3 4");
	}
}