/*
Enhance the Fibonacci program of Fig. 18.5 so that it calculates the approximate amount of time required to perform the calculation and the number of calls made to the recursive method.  For this purpose, call static System method currentTimeMillis, which takes no arguments and returns the computer's current time in milliseconds.  Call this method twice - once before and once after the call to fibonacci.  Save each value and calculate the difference in the times to determine how many milliseconds were required to perform the calculation.  Then, add a variable to the FibonacciCalculator class, and use this variable to determine the number of calls made to method fibonacci.  Display your results.
 */

import java.math.BigInteger;

class Main{
    private static BigInteger TWO = BigInteger.valueOf(2);
    private static long time;
    private static long callCount;

    public static void main(String[] args){
        for(int counter = 0; counter <= 40; ++counter){
            callCount = 0;
            time = System.currentTimeMillis();
            BigInteger fib = fibonacci(BigInteger.valueOf(counter));
            time = System.currentTimeMillis() - time;

            System.out.printf("Fibonacci of %2d is: %9d Time: %4d Calls: %9d%n", counter, fib, time, callCount);
        }
    }

    private static BigInteger fibonacci(BigInteger number) {
        ++callCount;
        if(number.equals(BigInteger.ZERO) ||
                number.equals(BigInteger.ONE)){
            return number;
        } else {
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }
}