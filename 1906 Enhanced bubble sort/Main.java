/*
Make the following simple modifications to improve the performance of the bubble sort you developed in Exercise 19.5:
A) After the first pass, the largest number is guaranteed to be in the highest numbered array element; after the second pass, the two highest numbers are "in place"; and so on.  Instead of making nine comparisons on every pass for a ten element array, modify the bubble sort to make eight comparisons on the second pass, seven on the third pass, and so on.
B) The data in the array may already be in proper or near proper order, so why make nine passes if fewer will suffice?  Modify the sort to check at the end of each pass whether any swaps have been made.  If there were none, the data must already be sorted, so the program should terminate.  If swaps have been made, at least one more pass is needed.

My notes: A) This is already a feature of my previous work.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        int[] arr = new SecureRandom().ints(100, 1, 100).toArray();

        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    private static void bubbleSort(int[] arr){
        for(int unsorted = arr.length; unsorted > 1; --unsorted){
            boolean isSorted = true;
            for(int test = 0; test < unsorted - 1; ++test){
                if(arr[test] > arr[test + 1]){
                    int temp = arr[test + 1];
                    arr[test + 1] = arr[test];
                    arr[test] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) { break; }
        }
    }

    private static void printArr(int[] arr){
        System.out.println("Printing");
        int col = 1;
        for(int num : arr){
            System.out.printf("%3d ", num);
            if (col % 10 == 0){
                System.out.println();
            }
            ++col;
        }
        System.out.println();
    }
}