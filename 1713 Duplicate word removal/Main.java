/*
Write a program that inputs a sentence from the user (assume no punctuation), then determines and displays the unique words in alphabetical order.  Treat uppercase and lowercase letters the same.
 */

import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        System.out.println("Enter a sentence.");
        String string = new Scanner(System.in).nextLine();

        Arrays.stream(string.split("\\s"))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}