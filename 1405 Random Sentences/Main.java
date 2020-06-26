/*
Write an application that uses random number generation to create sentences.  Use four arrays of strings called article, noun, verb, and preposition.  Create a sentence by selecting a word at random from each array in the following order:  article, noun, verb, preposition, article, and noun.  As each word is picked, concatenate it to the previous words in the sentence.  The words should be separated by spaces.  When the final sentence is output, it should start with a capital letter and end with a period.  The application should generate and display 20 sentences.
The article array should contain the articles "the", "a", "one", "some", and "any"; the noun array should contain the nouns "boy", "girl", "dog", "town", and "car"; the verb array should contain the verbs "drove", "jumped", "ran", "walked", and "skipped";  the preposition array should contain the prepositions "to", "from", "over", "under", and "on".
*/

import java.security.SecureRandom;

public class Main{
    public static void main(String[] args){
        SecureRandom rand = new SecureRandom();

        String[] artiArr = {"the", "a", "one", "some", "any"};
        String[] nounArr = {"boy", "girl", "dog", "town", "car"};
        String[] verbArr = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] prepArr = {"to", "from", "over", "under", "on"};


        for (int i = 0; i < 20; ++i){
            String word = artiArr[rand.nextInt(artiArr.length)];
            String sentence = word.substring(0, 1).toUpperCase() + word.substring(1);

            word = nounArr[rand.nextInt(nounArr.length)];
            sentence = sentence.concat(" " + word);

            word = verbArr[rand.nextInt(verbArr.length)];
            sentence = sentence.concat(" " + word);

            word = prepArr[rand.nextInt(prepArr.length)];
            sentence = sentence.concat(" " + word);

            word = artiArr[rand.nextInt(artiArr.length)];
            sentence = sentence.concat(" " + word);

            word = nounArr[rand.nextInt(nounArr.length)];
            sentence = sentence.concat(" " + word + ".");

            System.out.println(sentence);
        }
    }
}