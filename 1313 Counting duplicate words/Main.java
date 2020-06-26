/*
Write a program that determines and prints the number of duplicate words in a sentence.  Treat uppercase and lowercase letters the same.  Ignore punctuation.
 */

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] tok = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : tok){
            if(wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word) + 1);
            }
            else{
                wordMap.put(word, 1);
            }
        }

        int duplicateCount = 0;
        for(String word : wordMap.keySet()){
            if (wordMap.get(word) > 1){
                ++duplicateCount;
            }
        }
        System.out.printf("%d duplicates found%n", duplicateCount);
    }
}
