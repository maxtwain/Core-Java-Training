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

    void outputTree(){
        System.out.printf("%n%n");
        outputTreeHelper(0, root);
    }

    private void outputTreeHelper(int totalSpaces, TreeNode<E> currentNode){
        while(currentNode != null){
            outputTreeHelper(totalSpaces + 5, currentNode.rightNode);
            for(int spaces = 1; spaces < totalSpaces; ++spaces){
                System.out.print(' ');
            }
            System.out.printf("%2s%n", currentNode.data);
            currentNode = currentNode.leftNode;
            totalSpaces += 5;
        }
    }
}
