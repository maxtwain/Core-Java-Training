class List<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;

    List() {
        this("list");
    }
    private List(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insertAtFront(E insertItem){
        if(isEmpty()){
            firstNode = lastNode = new ListNode<>(insertItem);
        } else{
            firstNode = new ListNode<>(insertItem, firstNode);
        }
    }

    void insertAtBack(E insertItem){
        if(isEmpty()){
            firstNode = lastNode = new ListNode<>(insertItem);
        } else{
            lastNode = lastNode.nextNode = new ListNode<>(insertItem);
        }
    }

    private boolean isEmpty(){
        return firstNode == null;
    }

    void print(){
        if (isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s forward is: ", name);
        ListNode<E> current = firstNode;

        while (current != null) {

            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    void printListBackward(){
        System.out.printf("The %s backward is: ", name);
        printListBackwardHelper(firstNode);
    }

    private void printListBackwardHelper(ListNode<E> current){
        if(current.nextNode != null){
            printListBackwardHelper(current.nextNode);
        }
        System.out.printf("%s ", current.data);
    }
}
