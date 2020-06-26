import java.util.NoSuchElementException;

class List<E> {
    private ListNode<E> firstNode;
    private String name;

    List(){
        this("list");
    }

    List(String listName){
        name = listName;
        firstNode = null;
    }

    void insertAtFront(E insertItem){
        if(isEmpty()){
            firstNode = new ListNode<>(insertItem);
        } else{
            firstNode = new ListNode<>(insertItem, firstNode);
        }
    }

    void insertAtBack(E insertItem) {
        if(isEmpty()){
            firstNode = new ListNode<>(insertItem);
        } else{
            ListNode<E> node = firstNode;
            while(node.nextNode != null){
                node = node.nextNode;
            }
            node.nextNode = new ListNode<>(insertItem);
        }
    }

    E removeFromFront() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = firstNode.data;

        if(firstNode.nextNode == null){
            firstNode = null;
        } else{
            firstNode = firstNode.nextNode;
        }
        return removedItem;
    }

    E removeFromBack() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem;

        if(firstNode.nextNode == null){
            removedItem = firstNode.data;
            firstNode = null;
        } else if(firstNode.nextNode.nextNode == null) {
            removedItem = firstNode.nextNode.data;
            firstNode.nextNode = null;
        } else {
            ListNode<E> current = firstNode;

            while(current.nextNode.nextNode != null){
                current = current.nextNode;
            }
            removedItem = current.nextNode.data;
            current.nextNode = null;
        }
        return removedItem;
    }

    private boolean isEmpty(){
        return firstNode == null;
    }

    void print(){
        if(isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }
        System.out.printf("The %s is: ", name);
        ListNode<E> current = firstNode;

        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
}
