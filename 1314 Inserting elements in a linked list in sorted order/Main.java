/*
Write a program that inserts 25 random integers from 0 to 100 in order into a LinkedList object.  The program should sort the elements, then calculate the sum of the elements and the floating point average of the elements.
 */

import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Main{
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 25; ++i){
            list.add(secureRandom.nextInt(100));
        }

        Collections.sort(list);
        int sum = 0;
        for (int num : list){
            sum += num;
        }
        System.out.printf("Sum = %d%nAverage = %.2f%n", sum, ((double)sum) / 25);
    }
}