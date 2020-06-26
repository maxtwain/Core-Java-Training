/*
Write an application that calculates the squares and cubes of the numbers from 0 to 10 
and prints the resulting values in table format.
*/

public class Source {
	public static void main(String[] args) {
		System.out.printf("%-8s%-8s%-8s%n", "number", "square", "cube");
		System.out.printf("%-8s%-8s%-8s%n", 0, 0 * 0, 0 * 0 * 0);
		System.out.printf("%-8s%-8s%-8s%n", 1, 1 * 1, 1 * 1 * 1);
		System.out.printf("%-8s%-8s%-8s%n", 2, 2 * 2, 2 * 2 * 2);
		System.out.printf("%-8s%-8s%-8s%n", 3, 3 * 3, 3 * 3 * 3);
		System.out.printf("%-8s%-8s%-8s%n", 4, 4 * 4, 4 * 4 * 4);
		System.out.printf("%-8s%-8s%-8s%n", 5, 5 * 5, 5 * 5 * 5);
		System.out.printf("%-8s%-8s%-8s%n", 6, 6 * 6, 6 * 6 * 6);
		System.out.printf("%-8s%-8s%-8s%n", 7, 7 * 7, 7 * 7 * 7);
		System.out.printf("%-8s%-8s%-8s%n", 8, 8 * 8, 8 * 8 * 8);
		System.out.printf("%-8s%-8s%-8s%n", 9, 9 * 9, 9 * 9 * 9);
		System.out.printf("%-8s%-8s%-8s%n", 10, 10 * 10, 10 * 10 * 10);
	}
}