/*
Write an application that inputs an integer code for a character and displays the corresponding character.  Modify this application so that it generates all possible three digit codes in the range from 000 to 255 and attempts to print the corresponding characters.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a three digit character code: ");
        int code = scanner.nextInt();
        scanner.nextLine();

        char codeChar = ((char) code);
        System.out.printf("Your character: %c%n", codeChar);

        for(int i = 0; i < 256; ++i){
            System.out.printf("%03d: %c%n", i, (char) i);
        }
    }
}