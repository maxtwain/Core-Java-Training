/*
Our linked list class allowed insertions and deletions at only the front and the back of the linked list.  These capabilities were convenient for us when we used composition to produce a stack class and a queue class with minimal code simply by reusing the list class.  Linked lists are normally more general than those we provided.  Modify the linked list class we developed in this chapter to handle insertions and deletions anywhere in the list.  Create diagrams comparable to Figs. 21.5 (insertAtFront), 21.6 (insertAtBack), 21.7 (removeFrom Front), and 21,8 (removeFromBack) that show how to insert a new node in the middle of a linked list and how to remove an existing node from the middle of a linked list.
 */

import java.util.NoSuchElementException;

class Main{
    public static void main(String[] args){
        List<Integer> list = new List<>();

        list.insertAtMiddle(11);
        list.print();
        list.insertAtMiddle(22);
        list.print();
        list.insertAtMiddle(33);
        list.print();
        list.insertAtMiddle(44);
        list.print();

        try{
            int removedItem = list.removeAtMiddle();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeAtMiddle();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeAtMiddle();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeAtMiddle();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
}