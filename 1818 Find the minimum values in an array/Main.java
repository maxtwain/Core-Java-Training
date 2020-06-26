/*
Write a recursive method recursiveMinimum that determines the smallest element in an array of integers.  The method should return when it receives an array of one element.
 */

import java.security.SecureRandom;
import java.util.Arrays;

class Main{
    public static void main(String[] args){

        int[] intArr0 = new SecureRandom().ints(20, 1, 100).toArray();

        System.out.println("Array:");
        for(int num: intArr0){
            System.out.printf("%d ", num);
        }
        System.out.println();
        int min = recursiveMinimum(intArr0)[0];
        System.out.printf("Min = %d%n", min);

    }

    private static int[] recursiveMinimum(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        if (arr[arr.length - 2] > arr[arr.length - 1]){
            arr[arr.length - 2] = arr[arr.length - 1];
        }
        return recursiveMinimum(Arrays.copyOf(arr, arr.length - 1));
    }
}