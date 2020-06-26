/*
Write a static method reverseCopy that receives a List<E> as an argument and returns a copy of that List<E> with its elements reversed.  Test this method in an application.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        SortedList<Integer> list0 = new SortedList<>("list0");

        new SecureRandom().ints(4, 0, 100)
                .forEach(list0::insertSorted);

        list0.print();

        SortedList<Integer> reverseList = reverseCopy(list0);

        reverseList.print();
    }

    private static <T extends Comparable<T>> SortedList<T> reverseCopy(SortedList<T> inList){
        SortedList<T> reverseList = new SortedList<>("reverseList");

        while(!inList.isEmpty()){
            reverseList.insertAtBack(inList.removeFromBack());
        }
        return reverseList;
    }
}