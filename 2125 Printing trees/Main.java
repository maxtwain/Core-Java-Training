/*
Modify class Tree of Fig 21.15 to include a recursive outputTree method to display a binary tree object.  The method should output the tree row by row, with the top of the tree at the left of the screen and the bottom of the tree toward the right.  Each row is output vertically.  For example, the binary tree illustrated in Fig 21.18 is output as shown in Fig 21.23.
The rightmost leaf node appears at the output's top in the rightmost column and the root node appears at the output's left.  Each columns starts five spaces to the right of the preceding column.  Method outputTree should receive an argument totalSpaces representing the number of spaces preceding the value to be output.  (This variable should start at zero so that the root node is output at the left of the screen.)  The method uses a modified inorder traversal to output the tree - it starts at the rightmost node in the tree and works back to the left.  The algorithm is in Fig. 21.24.

Fig. 21.23
            99
        97
            92
    83
            72
        71
            69
49
            44
        40
            32
    28
            19
        18
            11

Fig. 21.24
While the reference to the current node is not null, perform the following:
    Recursively call outputTree with the right subtree of the current node and totalSpaces + 5.
    Use a for statement to count from 1 to totalSpaces and output spaces.
    Output the value in the current node.
    Set the reference to the current node to refer to the left subtree of the current node.
    Increment totalSpaces by 5.
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

        tree.outputTree();
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