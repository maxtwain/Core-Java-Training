// Write an application that uses String method regionMatches to compare two strings input by the user.  The application should input the number of characters to be compared and the starting index of the comparison.  The application should use whether the compared characters are equal.

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string 1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter index 1: ");
        int ind1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter string 2: ");
        String s2 = scanner.nextLine();
        System.out.print("Enter index 2: ");
        int ind2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter number of characters to compare: ");
        int len = scanner.nextInt();


        if (s1.regionMatches(true, ind1, s2, ind2, len)){
            System.out.println("The regions match.");
        }
        else{
            System.out.println("The regions do not match.");
        }
    }
}