/*
Write a program that inserts 25 random integers form 0 to 100 in order into a linked list object.  For this exercise, you'll need to modify the List<E> class (Fig. 21.3) to maintain an ordered list.  Name the new version of the class SortedList.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){

        SortedList<Integer> list0 = new SortedList<>("list0");

        new SecureRandom().ints(25, 0, 100)
                .boxed()
                .forEach(list0::insertSorted);

        list0.print();
    }
}