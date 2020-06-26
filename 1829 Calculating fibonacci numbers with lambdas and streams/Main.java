/*
Reimplement the fibonacci method of Fig 18.5 to calculate Fibonacci numbers using lambdas and streams, rather than recursion.
 */

import java.math.BigInteger;
import java.util.stream.IntStream;

class Main{
    private static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args){

        printFunctionalFib();
    }

    private static void printFib(){
        for (int counter = 0; counter <= 30; counter++){
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }
    }

    private static BigInteger fibonacci(BigInteger number){
        if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            return number;
        } else {
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }

    private static void printFunctionalFib(){
        IntStream.rangeClosed(0, 30).forEach(num -> {
            System.out.printf("Fibonacci of %2d is: ", num);
            if (num > 1){
                BigInteger bigSmall = BigInteger.valueOf(0);
                BigInteger bigFib = BigInteger.valueOf(1);
                for(int counter = 2; counter <= num; ++counter){
                    bigFib = bigFib.add(bigSmall);
                    bigSmall = bigFib.subtract(bigSmall);
                }
                System.out.println(bigFib);
            } else {
                System.out.println(num);
            }

        });
    }
}