class QueueNode<E extends Comparable<E>> {
    TreeNode<E> dataNode;
    QueueNode<E> nextNode;

    QueueNode(TreeNode<E> treeNode){
        this.dataNode = treeNode;
        nextNode = null;
    }

    TreeNode<E> get(){
        return dataNode;
    }
}
