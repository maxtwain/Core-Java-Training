/*
Write an application that reads a five letter word from the user and produces every possible three letter string that can be derived fromm the letters of that word.  For example, the three letter words produced form the word "bathe" include "ate", "bat", "bet", "tab", "bat", "the", and "tea".
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five letter word: ");
        String word = scanner.nextLine();

        char[] arr = new char[3];
        for(int i0 = 0; i0 < word.length(); ++i0){
            for(int i1 = 0; i1 < word.length(); ++i1){
                if(i0 == i1){
                    continue;
                }
                for(int i2 = 0; i2 < word.length(); ++i2){
                    if(i0 == i2 || i1 == i2){
                        continue;
                    }
                    arr[0] = word.charAt(i0);
                    arr[1] = word.charAt(i1);
                    arr[2] = word.charAt(i2);
                    System.out.println(String.valueOf(arr));
                }
            }
        }
    }
}
