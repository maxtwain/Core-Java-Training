/*
Create a program that reads integer grades and stores them in an ArrayList, then use stream processing to display each grade's letter equivalent (A, B, C, D, or F).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            System.out.printf("Score %02d: ", i);
            list.add(scanner.nextInt());
        }

        list.forEach(score -> System.out.printf("%d = %C%n", score, getLetter(score)));
    }

    private static char getLetter(int score){
        if (score > 89){
            return 'A';
        }
        else if(score > 79){
            return 'B';
        }
        else if(score > 69){
            return 'C';
        }
        else if(score > 59){
            return 'D';
        }
        else{
            return 'F';
        }
    }
}