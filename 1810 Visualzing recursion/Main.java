/*
It's interesting to watch recursion "in action."  Modify the factorial method in Fig. 18.3 to print its local variable and recursive call parameter.  For each recursive call, display the outputs on a separate line and add a level of indentation.  Do your utmost to make the outputs clear, interesting, and meaningful.  Your goal here is to design and implement an output format that makes it easier to understand recursion.  You may want to add such display capabilities to other recursion examples and exercises throughout the text.

My notes: Is number not the recursive call parameter?  I think that the original program was clearly written, and adding fluff code makes the program more difficult to understand rather than easier.
 */

class Main{
    public static void main(String[] args){
        for (int counter = 0; counter <= 21; counter++) {
            System.out.printf("%d! = %d%n", counter, factorial(counter));
        }
    }

    private static long factorial(long number) {
        System.out.printf("number = %d%n", number);
        if (number <= 1){
            return 1;
        }
        else {
            return number * factorial(number - 1);
        }
    }
}