/*
Write a program that inserts 30 random letters into a List<Character>.  Perform the following operations and display your results.

A) Sort the List in ascending order.
B) Sort the List in descending order.
C) Display the List in ascending order with duplicates removed.
 */

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args){

        List<Character> values =
                new SecureRandom()
                        .ints(30, 97, 123)
                        .mapToObj(ascInt -> (char)ascInt)
                        .collect(Collectors.toList());

        partC(values);

    }

    private static void partA(List<Character> list){
        System.out.println("Part A");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void partB(List<Character> list){
        System.out.println("Part B");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void partC(List<Character> list){
        System.out.println("Part C");
        list.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}