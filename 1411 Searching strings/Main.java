/*
Write an application that inputs a line of text and a search character and uses String method indexOf to determine the number of occurrences of the character in the text.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = scanner.nextLine();
        System.out.print("Enter a search character: ");
        char search = scanner.next().charAt(0);
        scanner.nextLine();

        int count = 0;
        for(int index = line.indexOf(search); index >= 0; ){
            ++count;
            index = line.indexOf(search, index + 1);
        }

        System.out.printf("Number of characters: %d%n", count);
    }
}