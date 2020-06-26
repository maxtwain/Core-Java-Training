/*
Write an application that inputs a telephone number as a string in the form (555) 555-5555.  The application should use String method split to extract the area code as a token, the first three digits of the phone number as a token, and the last four digits of the phone number as a token.  The seven digits of the phone number should be concatenated into one string.  Both the area code and the phone number should be printed.  Remember that you'll have to change delimiter characters during the tokenization process.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        String phone = scanner.nextLine();
        String[] tokenized = phone.split("\\D");

        int index = 0;
        while(index < tokenized.length && tokenized[index].isEmpty()){
            ++index;
        }
        String area = tokenized[index];
        ++index;

        while(index < tokenized.length && tokenized[index].isEmpty()){
            ++index;
        }
        String prefix = tokenized[index];
        ++index;

        while(index < tokenized.length && tokenized[index].isEmpty()){
            ++index;
        }
        String suffix = tokenized[index];

        String oneString = prefix + suffix;
        System.out.printf("Number of tokens: %d%n", tokenized.length);
        System.out.printf("Area code: %s%nRemaining: %s", area, oneString);
    }
}