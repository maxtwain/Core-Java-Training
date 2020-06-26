class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;

    Tree(){
        root = null;
    }

    void insertNode(E insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue);
        } else{
            root.insert(insertValue);
        }
    }

    void preorderTraversal(){
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode<E> node){
        if (node == null) {
            return;
        }

        System.out.printf("%S ", node.data);
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }

    void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode<E> node){
        if (node == null){
            return;
        }

        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
    }

    void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode<E> node) {
        if (node == null){
            return;
        }
        postorderHelper(node.leftNode);
        postorderHelper(node.rightNode);
        System.out.printf("%s ", node.data);
    }

    void levelorderTraversal(){
        Queue<E> queue = new Queue<>();
        if(root != null){
            queue.insert(root);
        }

        while(!queue.isEmpty()){
            QueueNode<E> queueNode = queue.remove();
            System.out.printf("%s ", queueNode.dataNode.data);

            if (queueNode.get().leftNode != null){
                queue.insert(queueNode.get().leftNode);
            }
            if(queueNode.get().rightNode != null){
                queue.insert(queueNode.get().rightNode);
            }
        }
    }
}
