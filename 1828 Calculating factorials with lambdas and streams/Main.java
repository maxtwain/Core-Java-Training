/*
Reimplement the factorial methods of Figs. 18.3-18.4 to calculate factorials using lambdas and streams, rather than recursion.
 */

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Main{
    public static void main(String[] args){

        printBigFunctionalFactorial();
    }

    private static void printFactorial(){
        for (int counter = 0; counter <= 21; counter++){
            System.out.printf("%2d! = %d%n", counter, factorial(counter));
        }
    }
    private static long factorial(long number) {
        if (number <= 1){
            return 1;
        }
        else {
            return number * factorial(number - 1);
        }
    }

    private static void printFunctionalFactorial(){
        LongStream.rangeClosed(0, 21).forEach(num -> {
            System.out.printf("%2d! = ", num);
            if (num == 0) { num = 1; }
            for (long numCopy = num - 1; numCopy > 1; --numCopy){
                num *= numCopy;
            }
            System.out.printf("%d%n", num);
        });
    }

    private static void printBigFunctionalFactorial(){
        IntStream.rangeClosed(0, 21).forEach(num -> {
            System.out.printf("%2d! = ", num);
            if (num == 0) { num = 1; }
            BigInteger big = BigInteger.valueOf(num);
            for (; num > 1; --num){
                big = big.multiply(BigInteger.valueOf(num));
            }
            System.out.printf("%d%n", big);
        });
    }
}