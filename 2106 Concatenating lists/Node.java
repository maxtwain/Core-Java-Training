class Node<E> {
    E data;
    Node<E> nextNode;

    Node(E data) {
        this(data, null);
    };

    Node(E data, Node<E> nextNode){
        this.data = data;
        this.nextNode = nextNode;
    };

    E getData() { return data; }

    Node<E> getNext(){
        return nextNode;
    }

    void setData(E data) {
        this.data = data;
    }

    void setNext(Node<E> next){
        nextNode = next;
    }

}
