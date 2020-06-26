/*
Modify the SortedList class from Exercise 21.7 to include a merge method that can merge the SortedList it receives as an argument with the SortedList that calls the method.  Write an application to test method merge.

My notes:  This is almost exactly what is asked in Exercise 06.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        SortedList<Integer> list0 = new SortedList<>("list0");
        SortedList<Integer> list1 = new SortedList<>("list1");

        new SecureRandom().ints(4, 0, 100)
                .boxed()
                .forEach(list0::insertSorted);
        new SecureRandom().ints(4, 0, 100)
                .boxed()
                .forEach(list1::insertSorted);


        list0.print();
        list1.print();
        list0.merge(list1);
        list0.print();
    }
}