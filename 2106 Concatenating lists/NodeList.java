import java.util.NoSuchElementException;

class NodeList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private String name;

    NodeList() {
        this("list");
    }

    NodeList(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insertAtFront(E item) {
        if (isEmpty()){
            lastNode = new Node<E>(item);
            firstNode = lastNode;
        } else {
            firstNode = new Node<E>(item, firstNode);
        }
    }

    void insertAtBack(E item){
        if(isEmpty()){
            lastNode = new Node<E>(item);
            firstNode = lastNode;
        } else{
            lastNode.nextNode = new Node<E>(item);
            lastNode = lastNode.nextNode;
        }
    }

    E removeFromFront() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E item = firstNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return item;
    }

    E removeFromBack() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        E item = lastNode.data;

        if (firstNode == lastNode){
            firstNode = lastNode = null;
        } else {
            Node<E> current = firstNode;

            while (current.nextNode != lastNode){
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        }
        return item;
    }

    void concatenate(NodeList<E> catList){
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
        Node<E> current = firstNode;

        while (current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
        System.out.println();
    }

}
