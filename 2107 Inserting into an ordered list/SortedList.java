import java.util.NoSuchElementException;

class SortedList<T extends Comparable<T>> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private String name;

    SortedList() {
        this("list");
    }

    SortedList(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insertAtFront(T item) {
        if (isEmpty()){
            lastNode = new Node<T>(item);
            firstNode = lastNode;
        } else {
            firstNode = new Node<T>(item, firstNode);
        }
    }

    void insertAtBack(T item){
        if(isEmpty()){
            lastNode = new Node<T>(item);
            firstNode = lastNode;
        } else{
            lastNode.nextNode = new Node<T>(item);
            lastNode = lastNode.nextNode;
        }
    }

    void insertSorted(T item){
        if(isEmpty()){
            lastNode = new Node<T>(item);
            firstNode = lastNode;
        } else if(firstNode.data.compareTo(item) > 0){
            firstNode = new Node<T>(item, firstNode);
        }
        else {
            Node<T> compareNode = firstNode;
            while(compareNode.nextNode != null
            && compareNode.nextNode.data.compareTo(item) < 0){
                compareNode = compareNode.nextNode;
            }
            Node<T> itemNode = new Node<T>(item, compareNode.nextNode);
            compareNode.setNext(itemNode);
        }
    }

    T removeFromFront() throws NoSuchElementException {
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

    T removeFromBack() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        T item = lastNode.data;

        if (firstNode == lastNode){
            firstNode = lastNode = null;
        } else {
            Node<T> current = firstNode;

            while (current.nextNode != lastNode){
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        }
        return item;
    }

    void concatenate(SortedList<T> catList){
        if(isEmpty()){
            lastNode = catList.firstNode;
            firstNode = lastNode;
        } else{
            lastNode.nextNode = catList.firstNode;
            lastNode = lastNode.nextNode;
        }
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
