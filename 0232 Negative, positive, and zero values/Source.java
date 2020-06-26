/*
Write a program that inputs five numbers and determines and prints the number of negative numbers 
input, the number of positive numbers input and the number of zeros input.
*/

import java.util.Scanner;

public class Source{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first integer: ");
		int num0 = input.nextInt();
		System.out.print("Enter the second integer: ");
		int num1 = input.nextInt();
		System.out.print("Enter the third integer: ");
		int num2 = input.nextInt();
		System.out.print("Enter the fourth integer: ");
		int num3 = input.nextInt();
		System.out.print("Enter the fifth integer: ");
		int num4 = input.nextInt();
		
		int pCount = 0;
		int nCount = 0;
		int zCount = 0;
		if(num0 > 0) {
			++pCount;
		}
		else if(num0 < 0) {
			++nCount;
		}
		else {
			++zCount;
		}
		if(num1 > 0) {
			++pCount;
		}
		else if(num1 < 0) {
			++nCount;
		}
		else {
			++zCount;
		}
		if(num2 > 0) {
			++pCount;
		}
		else if(num2 < 0) {
			++nCount;
		}
		else {
			++zCount;
		}
		if(num3 > 0) {
			++pCount;
		}
		else if(num3 < 0) {
			++nCount;
		}
		else {
			++zCount;
		}
		if(num4 > 0) {
			++pCount;
		}
		else if(num4 < 0) {
			++nCount;
		}
		else {
			++zCount;
		}
		
		System.out.printf("Positive count = %d%nNegative count = %d%nZero count = %d%n",
				pCount, nCount, zCount);
	}
}