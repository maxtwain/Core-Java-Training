import java.util.NoSuchElementException;

class NStack<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private String name;

    NStack(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insert(T item) {
        if (isEmpty()){
            lastNode = new Node<>(item);
            firstNode = lastNode;
        } else {
            firstNode = new Node<>(item, firstNode);
        }
    }

    T remove() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        T item = firstNode.getNodeData();

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return item;
    }

    T peekTopNode(){
        return firstNode.getNodeData();
    }

    boolean isEmpty() { return firstNode == null; }
}
