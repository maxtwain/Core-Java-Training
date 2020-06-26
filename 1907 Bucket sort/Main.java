/*
A bucket sort begins with a one dimensional array of positive integers to be sorted and a two dimensional array of integers with rows indexed from 0 to 9 and columns indexed from 0 to n - 1, where n is the number of values to be sorted.  Each row of the two dimensional array is referred to as a bucket.  Write a class named BucketSort containing a method called sort that operates as follows:
A) Place each value of the one dimensional array into a row of the bucket array, based on the value's "ones" (rightmost) digit.  For example, 97 is placed in row 7, 3 is placed in for 3 and 100 is placed in row 0.  This procedure is called a distribution pass.
B) Loop through the bucket array row by row, and copy the values back to the original array.  This procedure is called a gathering pass.  The new order of the preceding values in the one dimensional array is 100, 3, and 97.
C) Repeat this process for each subsequent digit position (tens, hundreds, thousands, ect).  On the second (tens digit) pass, 100 is placed in row 0, 3 is placed in row 0 (because 3 has no tens digit), and 97 is placed in row 9.  After the gathering pass, the order of the values in the one dimensional array is 100, 3, and 97.  On the third (hundreds digit) pass, 100 is placed in row 1, 3 is placed in row 0, and 97 is placed in row 0 (after the 3).  After this gathering pass, the original array is in sorted order.
The two dimensional array of buckets is 10 times the length of the integer array being sorted.  This sorting technique provides better performance than a bubble sort, but requires much more memory - the bubble sort requires space for only one additional element of data.  This comparison is an example of the space-time trade off:  The bucket sort uses more memory than the bubble sort, but performs better.  This version of the bucket sort requires copying all the data back to the original array on each pass.  Another possibility is to create a second two dimensional bucket array and repeatedly swap the data between the two bucket arrays.
 */

import java.security.SecureRandom;

class Main{
    private static final int NUM_LIMIT = 999999;
    private static final int NUM_COUNT = 100;

    public static void main(String[] args){
        int[] arr = new SecureRandom().ints(NUM_COUNT, 1, NUM_LIMIT).toArray();

        printArr(arr);
        bucketSort(arr);
        printArr(arr);
    }

    private static void bucketSort(int[] arr){
        DigitMatch[] bucket = new DigitMatch[10];
        for(int row = 0; row < 10; ++row){
            bucket[row] = new DigitMatch(NUM_COUNT);
        }

        int tenMax = (int)(Math.log10(NUM_LIMIT) + 1);
        for(int tenPow = 0; tenPow < tenMax; ++tenPow){

            for(int arrIndex = 0; arrIndex < NUM_COUNT; ++arrIndex){
                int digit = arr[arrIndex] % (int)Math.pow(10, tenPow + 1) / (int)Math.pow(10, tenPow);
                bucket[digit].setLast(arr[arrIndex]);
            }

            int gatherIndex = 0;
            for(int digit = 0; digit < 10; ++digit){
                while(bucket[digit].containsNum()){
                    arr[gatherIndex++] = bucket[digit].removeFirst();
                }
                bucket[digit].reset();
            }
        }
    }

    private static void printArr(int[] arr){
        System.out.println("Printing");
        int col = 1;
        for(int num : arr){
            System.out.printf("%6d ", num);
            if (col % 10 == 0){
                System.out.println();
            }
            ++col;
        }
        System.out.println();
    }
}