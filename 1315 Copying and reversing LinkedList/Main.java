/*
Write a program that creates a LinkedList object of 10 characters, then creates a second LinkedList object containing a copy of the first list, but in reverse order.
 */

import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Main{
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        List<Character> forwardList = new LinkedList<>();
        for (int i = 0; i < 10; ++i){
            int randNum = 'a' + secureRandom.nextInt('z' - 'a');
            forwardList.add((char) randNum);
        }

        for (char letter : forwardList){
            System.out.printf("%c", letter);
        }
        System.out.println();

        List<Character> backwardList = forwardList.subList(0, forwardList.size());
        Collections.reverse(backwardList);

        for (char letter : backwardList){
            System.out.printf("%c", letter);
        }
        System.out.println();
    }
}
