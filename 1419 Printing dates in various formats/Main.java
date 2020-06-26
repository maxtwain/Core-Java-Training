/*
Dates are printed in several common formats.  Two of the more common formats are "04/24/1955" and "April 25, 1955".  Write an application that reads a date in the first format and prints it in the second format.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date in the format 04/24/1955: ");
        String line = scanner.nextLine();
        String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        String[] tokenize = line.split("/");
        System.out.print(monthArr[Integer.parseInt(tokenize[0]) - 1] + " ");
        System.out.print(tokenize[1] + ", " + tokenize[2]);

    }
}
