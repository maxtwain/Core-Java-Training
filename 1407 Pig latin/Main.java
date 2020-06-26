/*
Write an application that encodes English language phrases into pig Latin.  Pig Latin is a form of coded language.  There are many different ways to form pig Latin phrases.  For simplicity, use the following algorithm:
To form a pig Latin phrase from an English language phrase, tokenize the phrase into words with String method spit.  To translate each English word into a pig Latin word, place the first letter of the English word at the end of the word and add the letters "ay".  Thus, the word "jump" becomes "umpjay", the word "the" becomes "hetay," and the word "computer" becomes "omputercay."  Blanks between words remain as blanks.  Assume the following: The English phrase consists of words separated by blanks, there are no punctuation marks, and all the words have two or more letters.  Method printLatinWord should display each word.  Each token is passed to method printLatinWord to print the pig Latin word.  Enable the user to input the sentence.  Then display the converted sentence.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String[] tokenized = sentence.split(" ");
        for(String token : tokenized){
            String pig;
            if (token.length() > 1){
                pig = token.substring(1, token.length()) + token.substring(0, 1) + "ay";
            }
            else {
                pig = token + "ay";
            }
            System.out.println(pig);
        }
    }
}