/*
Use an infinite stream of integers to display the first n prime numbers, where n is input by the user.
 */

import java.util.Scanner;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args){
        System.out.print("Enter n: ");
        int n = new Scanner(System.in).nextInt();

        IntStream.iterate(2, num -> nextPrime(num + 1))
                .limit(n)
                .forEach(num -> System.out.printf("%d, ", num));
    }

    private static int nextPrime(int num){
        if (num == 2) { return num; }
        if (num % 2 == 0) {
            ++num;
        }

        for(int divisor = 3; divisor * divisor <= num; ++divisor){
            if (num % divisor == 0){
                divisor = 3;
                num += 2;
            }
        }

        return num;
    }
}