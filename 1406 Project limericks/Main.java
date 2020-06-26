// A limerick is a humorous five line verse in which the first and second lines rhyme with the fifth, and the third line rhymes with the fourth.  Using techniques similar to those developed in Exercise 14.5, write a Java application that produces random limericks.  Polishing this application to produce good limericks is a challenging problem, but the results with be worth the effort!

import java.security.SecureRandom;

public class Main{
    public static void main(String[] args){
        SecureRandom rand = new SecureRandom();

        String[] rymeArr0 = {"air","bare","bear","blare","care", "chair","dare","err","fair","faire", "fare","flair","flare","glare","hair", "hare","heir","lair","mare","pair", "pare","pear","prayer","quare","rare", "scare","share","snare","spare","square", "stair","stare","swear","tare","tear", "their","there","they're","ware","wear", "where"};
        String[] rymeArr1 = {"an", 	"ann", 	"anne", 	"ban", 	"bran",
                "can", "clan", "dan", "fan", "fran",
                "jan", "khan", "klan", "man", "pan",
                "plan", "ran", "scan", "span", "stan",
                "tan", "than", "van"};
        String[] artiArr = {"the", "a", "one", "some", "any"};
        String[] nounArr = {"boy", "girl", "dog", "town", "car"};
        String[] verbArr = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] prepArr = {"to", "from", "over", "under", "on"};


        for (int i = 0; i < 5; ++i){
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

            if (i == 0 || i == 1 || i == 4){
                word = rymeArr0[rand.nextInt(rymeArr0.length)];
            }
            else{
                word = rymeArr1[rand.nextInt(rymeArr1.length)];
            }

            sentence = sentence.concat(" " + word + ".");

            System.out.println(sentence);
        }

    }
}