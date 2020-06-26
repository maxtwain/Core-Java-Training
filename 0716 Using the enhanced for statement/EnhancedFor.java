/*
 * Write an application that uses an enhanced for statement to sum the double values passed by the command line arguments. [Hint: Use the static method parseDouble of class Double to convert a String to a double value.]
 * 
 */

public class EnhancedFor{
	public static void main(String[] args) {
		double sum = 0.0;
		for (String num : args) {
			sum += Double.parseDouble(num);
		}
		System.out.println(sum);
	}
}