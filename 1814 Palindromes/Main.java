/*
A palindrome is a string that is spelled the same way forward and backward.  Some examples of palindromes are "radar," "able was i ere i saw elba" and (if spaces are ignored) "a man a plan a canal panama."  Write a recursive method testPalindrome that returns boolean value true if the string stored in an array is a palindrome and false otherwise.  The method should ignore spaces and punctuation in the string.  [Hint: String method toCharArray gets a char array containing the String's characters.]

My notes:  It is easier to eliminate punctuation and whitespace from a string than a char array.
 */

class Main{
    public static void main(String[] args){
        String string = "a man a plan a canal panama";
        System.out.printf("\"%s\" %s a palindrome%n", string, testPalindrome(string) ? "is" : "is not");
    }

    private static boolean testPalindrome(String string){
        char[] chars = string.replaceAll("[^a-zA-Z]", "").toCharArray();
        return recursiveTest(chars, 0);
    }

    private static boolean recursiveTest(char[] chars, int index){
        if (index * 2 > chars.length){
            return true;
        }
        else if (chars[index] == chars[chars.length - 1 - index]){
            return recursiveTest(chars, index + 1);
        }
        else{
            return false;
        }
    }
}