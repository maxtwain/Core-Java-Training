/*
Write an application based on the application in Exercise 14.11 that inputs a line of text and uses String method indexOf to determine the total number of occurrences of each letter of the alphabet in the text.  Uppercase and lowercase letters should be counted together.  Store the totals for each letter in an array, and print the values in tabular format after the totals have been determined.
 */


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        line = line.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] alphaRecord = new int[26];

        for(int alphaIndex = 0; alphaIndex < alphaRecord.length; ++alphaIndex){
            char letter = alphabet.charAt(alphaIndex);
            int count = 0;
            for(int lineIndex = line.indexOf(letter); lineIndex >= 0; ){
                ++count;
                lineIndex = line.indexOf(letter, lineIndex + 1);
            }
            alphaRecord[alphaIndex] = count;
        }

        for(int alphaIndex = 0; alphaIndex < alphaRecord.length; ++alphaIndex){
            char letter = alphabet.charAt(alphaIndex);
            System.out.printf("%c: %d%n", letter, alphaRecord[alphaIndex]);
        }

    }
}