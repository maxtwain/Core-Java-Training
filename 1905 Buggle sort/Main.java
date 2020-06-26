/*
Implement bubble sort - another simple yet inefficient sorting technique.  It's called bubble sort or sinking sort because smaller values gradually "bubble" their way to the top of the array(i.e. towards the first element) like air bubbles rising in water, while the larger values sink to the bottom (end) of the array.  The technique uses nested loops to make several passes through the array.  Each pass compares successive paris of elements.  If a pair is in increasing order (or the values are equal), the bubble sort leaves the values as they are.  If a pair is in decreasing order, the bubble sort swaps their values in the array.  The first pass compares the first two elements of the array and swaps their values if necessary.  It then compares the second and their elements in the array.  The end of this pass compares the last two elements in the array and swaps them if necessary.  After one pass, the largest element will be in the last index.  After two passes, the largest two elements will be in the last two indices.  Explain why bubble sort is an O(n^2) algorithm.

Answer: The outer loop runs n times.  Each element of the outer loop requires an inner loop to run an average of n/2 times.  Multiplied together, this gives an O of n * n / 2.  For large arrays, the / 2 becomes less significant and O can be simplified as O(n^2).
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
            for(int test = 0; test < unsorted - 1; ++test){
                if(arr[test] > arr[test + 1]){
                    int temp = arr[test + 1];
                    arr[test + 1] = arr[test];
                    arr[test] = temp;
                }
            }
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