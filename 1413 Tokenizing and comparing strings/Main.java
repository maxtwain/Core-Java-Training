/*
Write an application that reads a line of text, tokenizes the line using space characters as delimiters, and outputs only those words beginning with the letter "b"
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        String[] tokenize = line.split(" ");

        for(String word : tokenize){
            if(word.charAt(0) == 'b'){
                System.out.print(word + " ");
            }
        }
    }
}
