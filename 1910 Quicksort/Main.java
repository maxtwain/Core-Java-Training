/*
The recursive sorting technique called quicksort uses the following basic algorithm for a one dimensional array of values:
A) Partitioning Step: Take the first element of the unsorted array and determine its final location in the sorted array (i.e., all values to the left of the element in the array are less than the element, and all values to the right of the element in the array are greater than the element - we show how to do this below).  We now have one element in its proper location and two unsorted subarrays.
B) Recursive Step: Perform Step 1 on each unsorted subarray.  Each time Step 1 is performed on a subarray, another element is place in its final location of the sorted array, and two unsorted subarrays are created.  When a subarray consists of one element, that element is in its final location (because a one element array is already sorted).
The basic algorithm seems simple enough, but how do we determine the final position of the first element of each subarray?  As an example, consider the following set of values (the element in bold is the partitioning element - it will be placed in its final location in the sorted array):
=37= 2 6 4 89 8 10 12 68 45
Starting from the rightmost element of the array, compare each element with 37 until an element less than 37 is found;  then swap 37 and that element.  The first element less than 37 is 12, so 37 and 12 are swapped.  The new array is
<12> 2 6 4 89 8 10 =37= 68 45
Element 12 is in italics to indicate that it was just swapped with 37.
Starting from the left of the array, but beginning with the element after 12, compare each element with 37 until an element greater than 37 is found - then swap 37 and that element.  The first element greater than 37 is 89, so 37 and 89 are swapped.  The new array is
12 2 6 4 =37= 8 10 <89> 68 45
Starting from right, but beginning with the element before 89, compare each element with 37 until an element less than 37 is found - then swap 37 and that element.  The first element less than 37 is 10, so 37 and 10 are swapped.  The new array is
12 2 6 4 <10> 8 =37= 89 68 45
Starting from the left, but beginning with the element after 10, compare each element with 37 until an element greater than 37 is found - then swap 37 and that element.  There are no more elements greater than 37, so when we compare 37 with itself, we know that 37 has been placed in its final location in the sorted array.  Every value to the left of 37 is smaller than it, and every value to the right of 37 is larger than it.
Once the partition has been applied on the previous array, there are two unsorted subarrays.  The subarray with values less than 37 contains 12, 2, 6, 4, 10, and 8.  The subarray with values greater than 37 contains 89, 68, and 45.  The sort continues recursively, with both subarrays being partitioned in the same manner as the original array.
Based on the preceding discussion, write recursive method quickSortHelper to sort a one dimensional integer array.  The method should receive as arguments a starting index and an ending index on the original array being sorted.
 */

import java.security.SecureRandom;

class Main{
    private static final int NUM_LIMIT = 999999;
    private static final int NUM_COUNT = 100;

    public static void main(String[] args){
        int[] randArr = new SecureRandom().ints(NUM_COUNT, 1, NUM_LIMIT).toArray();

        printArr(randArr);
        quickSort(randArr, 0, randArr.length - 1);
        printArr(randArr);
    }

    private static void quickSort(int[] data, int start, int end){

        if (end - start > 1){
            int leftIndex = start;
            int rightIndex = end;
            while(leftIndex < rightIndex){

                while(data[leftIndex] < data[rightIndex]){
                    --rightIndex;
                }

                int swap = data[leftIndex];
                data[leftIndex] = data[rightIndex];
                data[rightIndex] = swap;

                while(data[leftIndex] < data[rightIndex]){
                    ++leftIndex;
                }

                swap = data[leftIndex];
                data[leftIndex] = data[rightIndex];
                data[rightIndex] = swap;
            }
            quickSort(data, start, leftIndex - 1);
            quickSort(data, leftIndex + 1, end);
        }
    }

    private static void printArr(int[] arr){
        int precision = (int)Math.log10(NUM_LIMIT) + 1;
        System.out.println("Printing");
        int col = 1;
        for(int num : arr){
            System.out.printf("%" + precision + "d ", num);
            if (col % 10 == 0){
                System.out.println();
            }
            ++col;
        }
        System.out.println();
    }
}