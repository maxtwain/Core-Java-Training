/*
Modify Fig. 19.3 to use recursive method recursiveBinarySearch to perform a binary search of the array.  The method should receive the search key, starting index, and ending index as arguments.  If the search key is found, return its index in the array.  If the search key is not found, return -1.
 */

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();

        int[] data = generator.ints(15, 10, 91).sorted().toArray();
        System.out.printf("%s%n%n", Arrays.toString(data));

        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInt = input.nextInt();

        while (searchInt != -1){
            int location = recursiveBinarySearch(data, searchInt, 0, data.length);

            if(location == -1){
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found in position %d%n%n", searchInt, location);
            }

            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }
    }

    private static int recursiveBinarySearch(int[] data, int searchKey, int start, int end){
        int middle = (start + end) / 2;

        if (start > end){
            return -1;
        } else if (searchKey == data[middle] ){
            return middle;
        } else if(searchKey < data[middle]){
            return recursiveBinarySearch(data, searchKey, start, middle - 1);
        } else{
            return recursiveBinarySearch(data, searchKey, middle + 1, end);
        }
    }

    private static int binarySearch(int[] data, int key){
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;

        do{
            System.out.print(remainingElements(data, low, high));

            for (int i = 0; i < middle; i++){
                System.out.print("   ");
            }
            System.out.println(" * ");

            if (key == data[middle]){
                location = middle;
            } else if(key < data[middle]){
                high = middle - 1;
            } else {
                low = middle + 1;
            }

            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));

        return location;
    }

    private static String remainingElements(int[] data, int low, int high){
        StringBuilder temporary = new StringBuilder();

        for (int i = 0; i < low; i++){
            temporary.append("   ");
        }

        for (int i = low; i <= high; ++i){
            temporary.append(data[i]).append(" ");
        }

        return String.format("%s%n", temporary);
    }
}