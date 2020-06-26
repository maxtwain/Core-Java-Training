import java.util.NoSuchElementException;

class NStack<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private String name;

    NStack() {
        this("list");
    }

    NStack(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insert(T item) {
        if (isEmpty()){
            lastNode = new Node<T>(item);
            firstNode = lastNode;
        } else {
            firstNode = new Node<T>(item, firstNode);
        }
    }

    T remove() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        T item = firstNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return item;
    }

    private boolean isEmpty() { return firstNode == null; }

    void print() {
        if (isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("%s is: ", name);
        Node<T> current = firstNode;

        while (current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
        System.out.println();
    }

}
