/*
Modify Fig. 19.2 to use recursive method recursiveLinearSearch to perform a linear search of the array.  The method should receive the search key and starting index as arguments.  If the search key is found, return its index in the array; otherwise, return -1.  Each call to the recursive method should check one index in the array.
 */

import java.security.SecureRandom;

class Main{
    private static final int NUM_LIMIT = 999999;
    private static final int NUM_COUNT = 100;

    public static void main(String[] args){
        int[] randArr = new SecureRandom().ints(NUM_COUNT, 1, NUM_LIMIT).toArray();

        int[] preciseArr = {1, 50, 29, 88};
        int searchKey = 50;
        int searchIndex = recursiveLinearSearch(0, preciseArr, searchKey);
        System.out.printf("Search key %s",
                searchIndex != -1 ? "found." : "not found.");
    }

    private static int recursiveLinearSearch(int index, int arr[], int searchKey){
        if (arr[index] == searchKey){
            return index;
        } else if (index == arr.length - 1){
            return -1;
        } else {
            return recursiveLinearSearch(index + 1, arr, searchKey);
        }
    }
}
