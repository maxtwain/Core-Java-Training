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

        System.out.printf("%s ", node.data);
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
}
