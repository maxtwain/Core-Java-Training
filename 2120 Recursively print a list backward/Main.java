/*
Modify the List<E> class of Fig. 21.3 to include method printListBackward that recursively outputs the items in a linked list object in reverse order.  Write a test program that creates a list of integers and prints the list in reverse order.
 */

class Main{
    public static void main(String[] args){
        List<Integer> list = new List<>();

        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtBack(1);
        list.insertAtBack(5);
        list.print();

        list.printListBackward();

    }
}