class Node<T extends Comparable<T>> {
    T data;
    Node<T> nextNode;

    Node(T data) {
        this(data, null);
    };

    Node(T data, Node<T> nextNode){
        this.data = data;
        this.nextNode = nextNode;
    };

    T getData() { return data; }
    Node getNext(){
        return nextNode;
    }
    void setData(T data) {
        this.data = data;
    }
    void setNext(Node<T> next){
        nextNode = next;
    }

}
