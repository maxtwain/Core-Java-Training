/*
Continuing the discussion in Exercise 14.20, we reiterate the importance of designing check writing systems to prevent alteration of check amounts.  One common security method requires that the amount be written in numbers and spelled out in words as well.  Even if someone is able to alter the numerical amount of the check, it is extremely difficult to change the amount in words.  Write an application that inputs a numeric check amount that is less than $1000 and writes thw word equivalent of the amount.  For example, the amount 112.43 should be written as ONE hundred TWELVE and 43/100.
 */

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a dollar amount: ");
        double payment = Double.parseDouble(scanner.nextLine());
        int cents = ((int) (payment * 100)) % 100;
        int ones = ((int) payment) % 10;
        int tens = ((int) payment) % 100 / 10;
        int hundreds = ((int) payment) / 100;

        //System.out.printf("hundreds: %d%ntens: %d%nones: %d%ncents: %d%n", hundreds, tens, ones, cents);

        String[] oneString = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        String[] teenString = {"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
        String[] tenString = {"TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

        StringBuilder buffer = new StringBuilder();
        if (hundreds > 0){
            buffer.append(oneString[hundreds - 1]);
            buffer.append(" hundred");
        }
        if (tens > 0){
            buffer.append(" ");
            if (tens == 1){
                buffer.append(teenString[ones - 1]);
            }
            else{
                buffer.append(tenString[tens - 2]);
                if (ones > 0){
                    buffer.append("-");
                    buffer.append(oneString[ones - 1]);
                }
            }
        }
        if (hundreds == 0 && tens == 0 && ones == 0){
            buffer.append("ZERO");
        }
        buffer.append(" and ");
        buffer.append(Integer.toString(cents));
        buffer.append("/100");

        System.out.println(buffer.toString());
    }
}