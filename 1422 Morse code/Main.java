/*
Write an application that reads an English language phrase and encodes it into Morse code.  Also write an application that reads a phrase in Morse code and converts it into the English language equivalent.  Use one blank between each Morse coded letter and three blanks between each Morse coded word.
 */

/*
My notes:  To make the blanks more visible in the morse code, I used X rather than spaces.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();

        String morse = phraseToMorse(line);
        String backAgain = morseToPhrase(morse);
        System.out.println(morse);
        System.out.println(backAgain);

    }

    private static String phraseToMorse(String phrase){
        phrase = phrase.toLowerCase();
        StringBuilder morse = new StringBuilder();

        for(char letter : phrase.toCharArray()){
            morse.append(letterToMorse(letter));
            morse.append("X");
        }

        return morse.toString();
    }

    private static String letterToMorse(char letter){
        switch (letter){
            case 'a': return ".-";
            case 'b': return "-...";
            case 'c': return "-.-.";
            case 'd': return "-..";
            case 'e': return ".";
            case 'f': return "..-.";
            case 'g': return "--.";
            case 'h': return "....";
            case 'i': return "..";
            case 'j': return ".---";
            case 'k': return "-.-";
            case 'l': return ".-..";
            case 'm': return "--";
            case 'n': return "-.";
            case 'o': return "---";
            case 'p': return ".--.";
            case 'q': return "--.-";
            case 'r': return ".-.";
            case 's': return "...";
            case 't': return "-";
            case 'u': return "..-";
            case 'v': return "...-";
            case 'w': return ".--";
            case 'x': return "-..-";
            case 'z': return "--..";
            case '1': return ".----";
            case '2': return "..---";
            case '3': return "...--";
            case '4': return "....-";
            case '5': return ".....";
            case '6': return "-....";
            case '7': return "--...";
            case '8': return "---..";
            case '9': return "----.";
            case '0': return "-----";
        }
        // space
        return "X";
    }

    private static String morseToPhrase(String morsePhrase){
        String[] tokMorsePhrase = morsePhrase.split("XXX");

        StringBuilder phrase = new StringBuilder();
        for(String morseWord : tokMorsePhrase){
            String[] tokMorseWord = morseWord.split("X");
            for(String morseLetter : tokMorseWord){
                phrase.append(morseToLetter(morseLetter));
            }
            phrase.append(" ");
        }

        return phrase.toString();
    }

    private static char morseToLetter(String morse){
        for(char letter = 'a'; letter <= 'z'; ++letter){
            if (morse.equals(letterToMorse(letter))){
                return letter;
            }
        }
        for(char letter = '0'; letter <= '9'; ++letter){
            if (morse.equals(letterToMorse(letter))){
                return letter;
            }
        }
        return ' ';
    }
}
