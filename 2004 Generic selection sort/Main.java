/*
Write a generic method selectionSort based on the sort program of Fig 19.4.  Write a test program that inputs, sorts, and outputs an Integer array and a Float array.  [Hint: Use <T extends Comparable<T>> in the type parameter section for method selectionSort, so that you can use method compareTo to compare the objects of the type that T represents.]
 */

import java.util.Arrays;

class Main{
    public static void main(String[] args){

        Integer[] data0 = {2, 8, -39, 904, 8, 0};
        Double[] data1 = {1.1, -5.68, 4.39, -0.01, 5.59};

        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data0));
        selectionSort(data0);
        System.out.printf("%nSorted array: %s%n", Arrays.toString(data0));

        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data1));
        selectionSort(data1);
        System.out.printf("%nSorted array: %s%n", Arrays.toString(data1));
    }

    private static <T extends Comparable<T>> void selectionSort(T[] data){
        for(int i = 0; i < data.length - 1; ++i){
            int smallest = i;

            for(int index = i + 1; index < data.length; ++index){
                if (data[smallest].compareTo(data[index]) > 0){
                    smallest = index;
                }
            }

            swap(data, i, smallest);
            printPass(data, i + 1, smallest);
        }
    }

    private static <T> void swap(T[] data, int first, int second){
        T temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    private static <T> void printPass(T[] data, int pass, int index){
        System.out.printf("after pass %2d: ", pass);

        for(int i = 0; i < index; ++i){
            System.out.printf("%s ", data[i]);
        }

        System.out.printf("%s* ", data[index]);

        for(int i = index + 1; i < data.length; ++i){
            System.out.printf("%s ", data[i]);
        }

        System.out.printf("%n               ");

        for (int j = 0; j < pass; j++){
            System.out.printf("-- ");
        }
        System.out.println();
    }
}