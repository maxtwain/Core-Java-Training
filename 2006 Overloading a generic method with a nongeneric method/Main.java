/*
Overload generic method printArray of Fig. 20.3 with a nongeneric version that specifically prints an array of Strings in neat, tabular format, as shown in the sample output that follows.

Array stringArray contains:
one     two     three   four
five    six     seven   eight
 */

class Main{
    public static void main(String[] args){
        Integer[] integerArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"one", "two", "three", "four", "five", "six", "seven", "eight"};

        printArray(stringArray);
    }

    private static <T> void printArray(T[] inputArray){
        for(T element : inputArray){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    private static void printArray(String[] inputArray){
        System.out.println("Array stringArray contains:");
        for(int i = 0; i < inputArray.length; ++i){
            System.out.printf("%-8s ", inputArray[i]);
            if(i == 3){
                System.out.println();
            }
        }
        System.out.println();
    }

}