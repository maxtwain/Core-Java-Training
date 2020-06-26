/*
Our linked list implementation (Fig. 21.3) used both a firstNode and a lastNode.  The lastNode was useful for the insertAtBack and removeFromBack methods of the List class.  The insertAtBack method corresponds to the enqueue method of the Queue class.  Rewrite the List class so that it does not use a lastNode.  Thus, any operations on the tail of a list must begin searching the list from the front.  Does this affect our implementation of the Queue class (Fig. 21.11)?
 */

import java.util.NoSuchElementException;

class Main{
    public static void main(String[] args){
        List<Integer> list = new List<>();

        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();
        list.insertAtBack(1);
        list.print();
        list.insertAtBack(5);
        list.print();

        try{
            int removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromFront();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();

            removedItem = list.removeFromBack();
            System.out.printf("%n%d removed%n", removedItem);
            list.print();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
}