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

    TreeNode<E> contains(E value){
        TreeNode<E> current = root;
        while(current != null && !current.data.equals(value)){
            if(value.compareTo(current.data) < 0){
                current = current.leftNode;
            } else{
                current = current.rightNode;
            }
        }
        return current;
    }
}
