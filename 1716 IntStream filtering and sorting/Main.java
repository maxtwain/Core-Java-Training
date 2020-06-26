/*
Use SecureRandom method ints to generate a stream of 50 random numbers in the range 1 to 999, then filter the resulting stream elements to select only the odd numbers and display the results in sorted order.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        new SecureRandom().ints(50, 1, 999)
                .filter(i -> i % 2 == 1)
                .sorted()
                .forEach(System.out::println);
    }
}