/*
 * A positive integer is prime if it's divisible by only 1 and itself.  
 * For example, 2, 3, 5, 7, are prime, but 4, 6, 8, and 9 are not.  
 * The number 1, by definition, is not prime.
 * 
 * A) Write a method that determines whether a number is prime.
 * 
 * B) Use this method in an application that determines and displays 
 * all the prime numbers less than 10,000.  How many numbers up to 
 * 10,000 do you have to test to ensure that you've found all the primes?
 * 
 * C) Initially, you might think that n/2 is the upper limit for 
 * which you must test to see whether a number n is prime, but you 
 * need only go as high as the square root of n.  Rewrite the program, 
 * and run it both ways.
 * 
 */

public class Prime {
	public static void main(String[] args) {
		
		for(int i = 0; i < 10000; ++i) {
			if(isPrime(i)) {
				System.out.printf("%5d", i);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num <= 10 || num % 2 == 0) {
			return num == 2 || num == 3 || num == 5 || num == 7; 
		}
		for (int div = 3; div * div < num; div += 2) {
			if (num % div == 0) {
				return false;
			}
		}
		return true;
	}
}