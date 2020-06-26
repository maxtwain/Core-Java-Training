/*
 * Use a one dimensional array to solve the following problem:  Write an application that inputs five numbers, each between 10 and 100, inclusive.  As each number is read, display it only if it's not a duplicate of a number already read.  Provide for the "worst case," in which all five numbers are different.  Use the smallest possible array to solve this problem.  Display the complete set of unique values input after the user enters each new value.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateElimination{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> uniArr = new ArrayList<Integer>();
		System.out.print("Enter a number: ");
		uniArr.add(input.nextInt());
		for (int i = 0; i < 4; ++i) {
			System.out.print("Enter a number: ");
			int uni = input.nextInt();
			if (!uniArr.contains(uni)) {
				uniArr.add(uni);
			}
		}
		System.out.println("\nContents:");
		for (int uni : uniArr) {
			System.out.println(uni);
		}
	}
}