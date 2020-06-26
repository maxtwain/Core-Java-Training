class Node<T> {
    private T nodeData;
    Node<T> nextNode;

    Node(T data) {
        this(data, null);
    }

    Node(T data, Node<T> nextNode){
        this.nodeData = data;
        this.nextNode = nextNode;
    }

    T getNodeData() { return nodeData; }
}
