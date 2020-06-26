/*
Computers are frequently employed in check writing systems, such as payroll, and accounts payable applications.  There are many strange stories about weekly paychecks being printed (by mistake) for amounts in excess of $1 million.  Incorrect amounts are printed by computerized check writing systems because of human error or machine failure.  Systems designers build controls into their systems to prevent such erroneous checks from being issued.
Another serious problem is the intentional alteration of a check amount by someone who plans to cash a check fraudulently.  To prevent a dollar amount from being altered, some computerized check writing systems employ a technique called check protection.  Checks designed for imprinting by computer contain a fixed number fo spaces in which the computer may print an amount.  Suppose a paycheck contains eight blank spaces in which the computer is supposed to print the amount of a weekly paycheck.  If the amount is large, then all eight of the spaces will be filled.  For example 1,230.50.  On the other hand, if the amount is less than $1000, then several of the spaces would ordinarily be left blank.  For example, 99.87 contains three blank spaces.  If a check is printed with blank spaces, it's easier for someone to alter the amount.  To prevent alteration, many check writing systems insert leading asterisks to protect the amount as follows: ***99.87
Write an application that inputs a dollar amount to be printed on a check, then print the amount in check protected format with leading asterisks if necessary.  Assume that nine spaces are available for printing the amount.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a dollar amount: ");
        String line = scanner.nextLine();

        int astCount = 8 - line.length();
        StringBuilder output = new StringBuilder(line);
        if (astCount < 0){
            System.out.println("Invalid entry.");
        }
        else{
            while(astCount > 0){
                output.insert(0, "*");
                --astCount;
            }
        }

        System.out.println(output.toString());
    }
}