/*
 * Rewrite Fig. 7.2 so that the size of the array is specified by the first command line argument.  If no command line argument is supplied, use 10 as the default size of the array.
 * 
 */

public class Command{
	public static int ARRAY_SIZE = 10;
	public static void main(String[] args) {
		if (args.length == 1) {
			ARRAY_SIZE = Integer.parseInt(args[0]);
		}
		int[] array = new int[ARRAY_SIZE];
		System.out.printf("%s%8s%n", "Index", "Value");
		
		for (int counter = 0; counter < array.length; counter++) {
			System.out.printf("%5d%8d%n", counter, array[counter]);
		}
	}
}