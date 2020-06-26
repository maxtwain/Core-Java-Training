/*
Write a recursive method stringReverse that takes a character array containing a string as an argument and prints the string backward.

My notes: ... character array containing a string...  A character array cannot hold a string.  It holds an array of characters.  A string may be made of a sequence of characters, but once they are a string, it is no longer an array.
 */

class Main{
    public static void main(String[] args){
        char[] sentence = "The red fox jumps over the lazy dog.".toCharArray();

        printArr(sentence, sentence.length - 1);
    }

    private static void printArr(char[] sentence, int index){
        if (index < 0){
            return;
        }
        System.out.print(sentence[index]);
        printArr(sentence, --index);
    }
}