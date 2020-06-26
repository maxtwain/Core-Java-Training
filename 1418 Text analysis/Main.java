/*
String manipulation enables interesting approaches to analysing the writings of great authors.  Much attention has been focused on whether William Shakespeare ever lived.  Some scholars believe there's substantial evidence indicating that Christopher Marlowe actually penned the masterpieces attributed to Shakespeare.  Researchers have used computers to find similarities in the writings of these two authors.  This exercise examines three methods for analyzing texts with a computer.
A) Write an application that reads a line of text from the keyboard and prints a table indicating the number of occurrences of each letter of the alphabet in the text.  For example, the phrase "To be, or not to be: that is the question:" contains one "a", two "b", no "c", and so on.
B) Write an application that reads a line of text and prints a table indicating the number of one letter words, two letter words, three letter words, and so on, appearing in the text.  For example, Fig 14.25 shows the counts for the phrase "Whether 'tis nobler in the mind to suffer."
C) Write an application that reads a line of text and prints a table indicating the number of occurrences of each different word in the text.  The application should include the words in the table in the same order in which they appear in the text.  For example, the lines "To be, or not to be: that is the question: Whether 'tis nobler in the mind to suffer" contain the word "to" three times, the word "be" two times, the word "or" once, etc.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        line = line.toLowerCase();
        //printCharCount(line);
        //printWordLength(line);
        printWordCount(line);

    }

    private static void printCharCount(String data){
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int alphaIndex = 0; alphaIndex < alphabet.length(); ++alphaIndex){
            int count = 0;
            for(char letter : data.toCharArray()){
                if(letter == alphabet.charAt(alphaIndex)){
                    ++count;
                }
            }
            System.out.printf("%c: %d%n", alphabet.charAt(alphaIndex), count);
        }
    }

    private static void printWordLength(String data){
        String[] tokenize = data.split(" ");
        int[] lengthRecord = new int[7];
        for(String word : tokenize){
            ++lengthRecord[word.length() - 1];
        }

        for(int index = 0; index < lengthRecord.length; ++index){
            System.out.printf("%d: %d%n", index + 1, lengthRecord[index]);
        }
    }

    private static void printWordCount(String data){
        String[] tokenize = data.split(" ");
        WordClass[] wordSet = new WordClass[tokenize.length];
        for(int i = 0; i < wordSet.length; ++i){
            wordSet[i] = new WordClass();
        }

        for(String dataWord : tokenize){
            for(WordClass wordClass : wordSet){
                if(dataWord.equals(wordClass.getWord())){
                    wordClass.addCount();
                    break;
                }
                else if(wordClass.getWord().isEmpty()){
                    wordClass.newWord(dataWord);
                    break;
                }
            }
        }

        for(WordClass wordClass : wordSet){
            if(wordClass.getCount() > 0){
                System.out.printf("%s: %d%n", wordClass.getWord(), wordClass.getCount());
            }
        }
    }
}