class List<E extends Comparable<E>> {
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

    String getName(){
        return name;
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

        System.out.printf("The %s is: ", name);
        ListNode<E> current = firstNode;

        while (current != null) {

            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }

    boolean hasItem(E item){
        return hasItemHelper(item, firstNode);
    }

    private boolean hasItemHelper(E item, ListNode<E> currentNode){
        if(currentNode.getData().equals(item)){
            return true;
        } else if(currentNode.nextNode == null){
            return false;
        }
        return hasItemHelper(item, currentNode.nextNode);
    }
}
