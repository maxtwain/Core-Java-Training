/*
Write an application that inputs a line of text and outputs the text twice - once in all uppercase letters and once in all lowercase letters.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();

        System.out.println(line.toUpperCase());
        System.out.println(line.toLowerCase());
    }
}
