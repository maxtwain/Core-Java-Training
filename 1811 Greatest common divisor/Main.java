/*
The greatest common divisor of integers x and y is the largest integer that evenly divides into both x and y.  Write a recursive method gcd that returns the greatest common divisor of x and y.  The gcd of x and y is defined recursively as follows:  If y is equal to 0, then gcd(x, y) is x; otherwise, gcd(x, y) is gcd(y, x % y), where % is the remainder operator.  Use this method to replace the one you write in the application of Exercise 6.27
 */

class Main{
    public static void main(String[] args){
        System.out.println(gcd(100, 80));
    }

    private static int gcd(int x, int y){
        if (y == 0){
            return x;
        }
        else{
            return gcd(y, x % y);
        }
    }
}