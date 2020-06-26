/*
Write a program that takes a whole number input from a user and determines whether it's prime.  If the number is not prime, display its unique prime factors.  Remember that a prime number's factors are only 1 and the prime number itself.  Every number that's not prime has a unique prime factorization.  For example, consider the number 54.  The prime factors of 54 are 2, 3, 3, and 3.  When the values are multiplied together, the result is 54.  For the number 54, the prime factors output should be 2 and 3.  Use Sets as part of your solution.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String stringInput = scanner.nextLine();

        int num = 0;
        if (isPosInteger(stringInput)){
            num = Integer.parseInt(stringInput);
        }
        else{
            System.out.println("Input error");
            return;
        }

        int numCopy = num;
        Set<Integer> primeSet = new HashSet<>();
        while (num % 2 == 0){
            primeSet.add(2);
            num /= 2;
        }
        for(int i = 3; i <= Math.sqrt(num) ; i += 2){
            while (num % i == 0){
                primeSet.add(i);
                num /= i;
            }
        }
        if (num > 1){
            primeSet.add(num);
        }

        if (primeSet.size() > 1){
            System.out.printf("%d is not prime%n", numCopy);
            System.out.print("Prime factors = ");
            for( int prime : primeSet){
                System.out.printf("%d ", prime);
            }
        }
        else{
            System.out.printf("%d is prime%n", numCopy);
        }

    }

    private static boolean isPosInteger(String string){
        int radix = 10;
        if(string.isEmpty()){
            return false;
        }
        for (int i = 0; i < string.length(); ++i){
            if (Character.digit(string.charAt(i), radix) < 0){
                return false;
            }
        }
        return true;
    }
}