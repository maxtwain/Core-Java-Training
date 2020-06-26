/*
The program of Figs. 21.15 and 21.16 illustrated three recursive methods of traversing a binary tree - inorder, preorder, and postorder traversals.  This exercise presents the level order traversal of a binary tree, in which the node values are printed level by level, starting at the root node level.  The nodes on each level are printed from left to right.  The level order traversal is not a recursive algorithm.  It uses a queue object to control the output of the nodes.  The algorithm is shown in Fig 21.22.  Write method levelOrder to perform a level order traversal of a binary tree object.  Modify the program of Figs. 21.15 and 21.16 to use this method.  [Note: You'll also need to use the queue processing methods of Fig. 21.11 in this program.]

Fig. 21.22
Insert the root node in the queue.

While there are nodes left in the queue, do the following:
    Get the next node in the queue.
    Print the node's value.

    If the reference to the left child of the node is not null:
        Insert the left child node in the queue.

    If the reference to the right child of the node is not null:
        Insert the right child node in the queue.

 */

class Main{
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();
        createTree(tree);

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();

        System.out.printf("%n%nLevelorder traversal%n");
        tree.levelorderTraversal();
    }

    private static void createTree(Tree<Integer> tree){
        tree.insertNode(16);

        tree.insertNode(8);
        tree.insertNode(24);

        tree.insertNode(4);
        tree.insertNode(12);
        tree.insertNode(20);
        tree.insertNode(28);

        tree.insertNode(2);
        tree.insertNode(6);
        tree.insertNode(10);
        tree.insertNode(14);
        tree.insertNode(18);
        tree.insertNode(22);
        tree.insertNode(26);
        tree.insertNode(30);
    }
}