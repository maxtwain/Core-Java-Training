import java.util.NoSuchElementException;

class CStack {
    private Node firstNode;
    private Node lastNode;
    private String name;

    CStack() {
        this("list");
    }

    CStack(String listName){
        name = listName;
        firstNode = lastNode = null;
    }

    void insert(Character item) {
        if (isEmpty()){
            lastNode = new Node (item);
            firstNode = lastNode;
        } else {
            firstNode = new Node (item, firstNode);
        }
    }

    Character remove() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }

        Character item = firstNode.getFix().get();

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return item;
    }

    FixCharacter peek(){
        return firstNode.getFix();
    }

    boolean isEmpty() { return firstNode == null; }

    void print() {
        if (isEmpty()){
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("%s is: ", name);
        Node current = firstNode;

        while (current != null){
            System.out.printf("%s ", current.getFix().get());
            current = current.nextNode;
        }
        System.out.println();
    }
}
