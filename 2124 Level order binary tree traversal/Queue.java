class Queue<E extends Comparable<E>> {
    private QueueNode<E> firstNode;
    private QueueNode<E> lastNode;

    Queue(){
        firstNode = null;
        lastNode = null;
    }

    void insert(TreeNode<E> data){
        QueueNode<E> newNode = new QueueNode<>(data);

        if(lastNode == null){
            firstNode = lastNode = newNode;
            firstNode.nextNode = lastNode;
        } else{
            lastNode.nextNode = newNode;
            lastNode = newNode;
        }
    }

    QueueNode<E> remove(){
        if(firstNode == null){
            throw new RuntimeException("No node to remove");
        }
        QueueNode<E> removedNode = firstNode;
        if(firstNode == lastNode){
            firstNode = lastNode = null;
        } else{
            firstNode = firstNode.nextNode;
        }
        return removedNode;
    }

    boolean isEmpty(){
        return firstNode == null;
    }
}
