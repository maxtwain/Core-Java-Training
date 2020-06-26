/*
Figures 4.8 and 4.10 demonstrated calculating a class average with counter controlled repetition and sentinel controlled repetition respectively.  Create a program that reads integer grades and stores them in an ArrayList, then use stream processing to perform the average calculation.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            System.out.printf("Grade %02d: ", i);
            list.add(scanner.nextInt());
        }

        System.out.printf("Average = %.2f",
            list.stream()
                .mapToDouble(i -> (double)i)
                .average()
                .getAsDouble()
        );
    }
}