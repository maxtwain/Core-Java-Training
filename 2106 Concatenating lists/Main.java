/*
Write a program that concatenates two linked list objects of characters.  Class ListConcatenate should include a static method concatenate that takes references to both list objects as arguments and concatenates the second list to the first list.
 */

class Main{
    public static void main(String[] args){
        NodeList<Integer> list0 = new NodeList<>("list0");
        list0.insertAtFront(58);
        list0.insertAtBack(48);
        list0.insertAtBack(888);
        list0.insertAtFront(25);

        NodeList<Integer> list1 = new NodeList<>("list1");
        list1.insertAtFront(229);
        list1.insertAtBack(593);
        list1.insertAtBack(744);
        list1.insertAtFront(92);

        list0.print();
        list1.print();

        list0.concatenate(list1);

        list0.print();

    }
}