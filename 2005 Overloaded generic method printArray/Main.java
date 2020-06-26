/*
Overload generic method printArray of Fig 20.3 so that it takes two additional integer arguments, lowSubscript and highSubscript.  A call to this method prints only the designated portion of the array.  Validate lowSubscript and highSubscript.  If either is out of range, the overloaded printArray method should throw an InvalidSubscriptException; otherwise, printArray should return the number of elements printed.  Then modify main to exercise both versions of printArray on arrays integerArray, doubleArray, and characterArray.  Test all capabilities of both versions of printArray.
 */

class Main{
    public static void main(String[] args){
        Integer[] integerArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.printf("Array integerArray 1 to 3: ");
        int count = printArray(integerArray, 1, 3);
        System.out.printf("Items printed: %d%n", count);

        System.out.printf("Array doubleArray 0 to 6: ");
        count = printArray(doubleArray, 0, 6);
        System.out.printf("Items printed: %d%n", count);

        System.out.printf("Array characterArray 3 to 5: ");
        count = printArray(characterArray, 3, 5);
        System.out.printf("Items printed: %d%n", count);
    }

    private static <T> void printArray(T[] inputArray){
        for(T element : inputArray){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
    private static <T> int printArray(T[] inputArray, int lowSubscript, int highSubscript){
        if(lowSubscript < 0 ||
                highSubscript >= inputArray.length){
            throw new InvalidSubscriptException();
        }

        for(int i = lowSubscript; i <= highSubscript; ++i){
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();

        return highSubscript - lowSubscript + 1;
    }

}