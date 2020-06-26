/*
Write a program that uses a stack to determine whether a string is a palindrome (i.e., the string is spelled identically backward and forward).  The program should ignore spaces and punctuation.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args){
        String[] exampleArr = {
                // These are palindromes
                "A nut for a jar of tuna.",
                "Al lets Dell Ed \"Stella\"",
                "Are we not pure? \"No, sir!\" Panama's moody Noriega brags. \"It is garbage!\" Irony dooms a man - a prisoner up to new era.",
                "Borrow or rob?",
                // These are not palindromes
                "The quick brown fox jumps over the lazy dog.",
                "noPal"
        };

        for(String example : exampleArr){
            NStack<Character> nStack = new NStack<>("nStack");
            char[] exampleCharArr = example.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
            for(Character c : exampleCharArr){
                nStack.insert(c);
            }

            boolean isPal = true;
            for(Character c : exampleCharArr){
                char sChar = nStack.remove();
                if(c != sChar){
                    isPal = false;
                }
            }

            System.out.printf("%s%n%s a palindrome.%n%n", example, isPal ? "Is" : "Is not");
        }
    }
}