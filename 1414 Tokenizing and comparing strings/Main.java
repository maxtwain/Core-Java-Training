/*
Write an application that reads a line of text, tokenizes it using space characters as delimiters, and outputs only those words ending with the letters "ED".
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        String[] tokenize = line.split(" ");

        for(String word : tokenize){
            if (word.endsWith("ED")) {
                System.out.print(word + " ");
            }
        }
    }
}