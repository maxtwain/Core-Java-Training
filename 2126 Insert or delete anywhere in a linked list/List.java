import java.util.NoSuchElementException;

class List<E> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name;
    private int listSize;

    List(){
        this("list");
    }

    List(String listName){
        name = listName;
        firstNode = lastNode = null;
        listSize = 0;
    }

    void insertAtFront(E insertItem){
        if(isEmpty()){
            firstNode = lastNode = new ListNode<>(insertItem);
        } else{
            firstNode = new ListNode<>(insertItem, firstNode);
        }
        ++listSize;
    }

    void insertAtBack(E insertItem) {
        if(isEmpty()){
            firstNode = lastNode = new ListNode<>(insertItem);
        } else{
            lastNode = lastNode.nextNode = new ListNode<>(insertItem);
        }
        ++listSize;
    }

    E removeFromFront() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = firstNode.data;

        if(firstNode == lastNode){
            firstNode = lastNode = null;
        } else{
            firstNode = firstNode.nextNode;
        }
        --listSize;
        return removedItem;
    }

    E removeFromBack() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem = lastNode.data;

        if(firstNode == lastNode){
            firstNode = lastNode = null;
        } else{
            ListNode<E> current = firstNode;

            while(current.nextNode != lastNode){
                current = current.nextNode;
            }
            lastNode = current;
            current.nextNode = null;
        }
        --listSize;
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

    void insertAtMiddle(E insertItem){
        ListNode<E> insertNode = new ListNode<>(insertItem);

        if(isEmpty()){
            firstNode = lastNode = insertNode;
        } else{
            ListNode<E> currentNode = firstNode;
            for(int nodeCount = listSize / 2 - 1; nodeCount > 0; --nodeCount){
                currentNode = currentNode.nextNode;
            }

            insertNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = insertNode;
        }
    }

    E removeAtMiddle() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E removedItem;

        if(firstNode.nextNode == null){
            removedItem = firstNode.data;
            firstNode = null;
        } else if(firstNode.nextNode.nextNode == null){
            removedItem = firstNode.nextNode.data;
            firstNode.nextNode = null;
        } else{
            ListNode<E> currentNode = firstNode;
            for(int nodeCount = listSize / 2 - 1; nodeCount > 0; --nodeCount){
                currentNode = currentNode.nextNode;
            }
            removedItem = currentNode.nextNode.data;
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }

        return removedItem;
    }
}
