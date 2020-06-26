/*
Write a program that uses a String method split to tokenize a line of text input by the user and places each token in a TreeSet.  Print the elements of the TreeSet.  [Note: This should cause the elements to be printed in ascending sorted order.]
 */

import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        String[] tok = input.split(" ");

        for (String word : tok){
            System.out.printf("%s ", word);
        }
        System.out.println();

        Set<String> set = new TreeSet<>(Arrays.asList(tok));

        for (String word : set){
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
}