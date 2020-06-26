/*
Modify the List<E> class of Fig. 21.3 to include method search that recursively searches a linked list object for a specific value.  The method should return a reference to the value if it's found; otherwise, it should return null.  Use your method in a test program that creates a list of integers.  The program should prompt the user for a value to locate in the list.
 */

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        List<Integer> list = new List<>();

        list.insertAtFront(-1);
        list.insertAtFront(0);
        list.insertAtBack(1);
        list.insertAtBack(5);
        list.print();

        System.out.print("Enter a search value: ");
        Integer searchValue = new Scanner(System.in).nextInt();

        System.out.printf("%s %s %d.%n", list.getName(), list.hasItem(searchValue)?"contains":"does not contain", searchValue);
    }
}