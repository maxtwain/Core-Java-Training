/*
Write a recursive method printArray that displays all the elements in an array of integers, separated by spaces.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        int[] numberArr = new SecureRandom()
                .ints(20, 1, 100 )
                .toArray();

        printArray(numberArr, 0);
    }

    private static void printArray(int[] numberArr, int index){
        if(index == numberArr.length){
            return;
        }
        System.out.printf("%d ", numberArr[index]);
        ++index;
        printArray(numberArr, index);
    }
}