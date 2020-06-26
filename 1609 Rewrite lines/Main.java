/*
Rewrite lines 10-25 in Fig. 16.3 to be more concise by using the asList method and the LinkedList constructor that takes a Collection argument.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Main{
    public static void main(String[] args){
        String[] colorArr0 = {"black", "yellow", "green", "blue", "violent", "silver"};
        List<String> list0 = new LinkedList<>(Arrays.asList(colorArr0));

        String[] colorArr1 = {"gold", "white", "brows", "blue", "gray", "silver"};
        List<String> list1 = new LinkedList<>(Arrays.asList(colorArr1));

        list0.addAll(list1);
        list1 = null;
        printList(list0);

        convertToUppercaseStrings(list0);
        printList(list0);

        System.out.printf("%nDeleting elements 4 to 6...");
        removeItems(list0, 4, 7);
        printList(list0);
        printReversedList(list0);
    }

    private static void printList(List<String> list){
        System.out.printf("%nlist:%n");

        for(String color:list) {
            System.out.printf("%s ", color);
        }
        System.out.println();
    }

    private static void convertToUppercaseStrings(List<String> list){
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()){
            String color = iterator.next();
            iterator.set(color.toUpperCase());
        }
    }

    private static void removeItems(List<String> list, int start, int end){
        list.subList(start, end).clear();
    }

    private static void printReversedList(List<String> list){
        ListIterator<String> iterator = list.listIterator(list.size());

        System.out.printf("%nReveresed List:%n");

        while(iterator.hasPrevious()){
            System.out.printf("%s ", iterator.previous());
        }
    }
}