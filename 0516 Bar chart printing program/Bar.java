/*
 * One interesting application of computers 
 * is to display graphs and bar charts.  
 * Write an application that reads five 
 * numbers between 1 and 30.  For each 
 * number that's read, your program should 
 * display the same number of adjacent 
 * asterisks.  For example, if your 
 * program reads the number 7, it should 
 * display *******.  Display the bars of 
 * asterisks after you read all five numbers.
 */
import java.util.Scanner;

public class Bar{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num0 = input.nextInt();
		System.out.print("Enter a number: ");
		int num1 = input.nextInt();
		System.out.print("Enter a number: ");
		int num2 = input.nextInt();
		System.out.print("Enter a number: ");
		int num3 = input.nextInt();
		System.out.print("Enter a number: ");
		int num4 = input.nextInt();
		System.out.println();
		
		graph(num0);
		graph(num1);
		graph(num2);
		graph(num3);
		graph(num4);
	}
	
	public static void graph(int num) {
		for(;num > 0; --num) {
			System.out.print('*');
		}
		System.out.println();
	}
}