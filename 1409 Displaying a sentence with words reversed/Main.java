/*
Write an application that inputs a line of text, tokenizes the line with String method split, and outputs the tokens in reverse order.  Use space characters as delimiters.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        String[] tokenize = line.split(" ");
        for(int i = tokenize.length - 1; i >= 0; --i){
            System.out.print(tokenize[i] + " ");
        }
        System.out.println();
    }
}
