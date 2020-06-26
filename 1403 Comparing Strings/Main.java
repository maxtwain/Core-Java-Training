// Write an application that uses String method compareTo to compare two strings input by the user.  Output whether the first string is less than, equal to, or greater than the second.

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter string 2: ");
        String s2 = scanner.nextLine();

        if (s1.compareTo(s2) == 0){
            System.out.println("The string contents are equal");
        }
        else if (s1.compareTo(s2) > 0){
            System.out.println("The contents of string 1 are greater than string 2");
        }
        else{
            System.out.println("The contents of string 2 are greater than string 1");
        }
    }
}
