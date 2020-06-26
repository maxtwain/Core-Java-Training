/*
In this exercise, we discuss deleting items from binary search trees.  The deletion algorithm is not as straightforward as the insertion algorithm.  Three cases are encountered when deleting an item - the item is contained in a leaf node (i.e., it has no children), or in a node that has one child, or in a node that has two children.
If the item to be deleted is contained in a leaf node, the node is deleted and the reference in the parent node is set to null.
If the item to be deleted is contained in a node with one child, the reference in the parent node is set to reference the child node and the node containing the data item is deleted.  This causes the child node to take the place of the deleted node in the tree.
The last case is the most difficult.  When a node with two children is deleted, another node in the tree must take its place.  However, the reference in the parent node cannot simply be assigned to reference one of the children of the node to be deleted.  In most cases, the resulting binary search tree would not embody the following characteristics of binary search trees (with no duplicate values): The values in any left subtree are less than the value in the parent node, and the values in any right subtree are greater than the value in the parent node.
Which node is used as a replacement node to maintain this characteristic?  It's either the node containing the largest value in the tree less than the value in the node being deleted, or the node containing the smallest value in the tree greater than the value in the node being deleted.  Let's consider the node with the smaller value.  In a binary search tree, the largest value less than a parent's value is located in the left subtree of the parent node and is guaranteed to be contained in the rightmost node of the subtree.  This node is located by walking down the left subtree to the right until the reference to the right child of the current node is null.  We're now referencing the replacement node, which is either a leaf node or a node with one child to its left.  If the replacement node is a leaf node, the steps to perform the deletion are as follows:

A) Store the reference to the node to be deleted in a temporary reference variable.
B) Set the reference in the parent of the node being deleted to reference the replacement node.
C) Set the reference in the parent of the replacement node to null.
D) Set the reference to the right subtree in the replacement node to reference the right subtree of the node to be deleted.
E) Set the reference to the left subtree in the replacement node to reference the left subtree of the node to be deleted.

The deletion steps for a replacement node with a left child are similar to those for a replacement node with no children, but the algorithm also must move the child into the replacement node's position in the tree.  If the replacement node is a node with a left child, the steps to perform the deletion are as follows:

A) Store the reference to the node to be deleted in a temporary reference variable.
B) Set the reference in the parent of the node being deleted to refer to the replacement node.
C) Set the reference in the parent of the replacement node to reference the left child of the replacement node.
D) Set the reference to the right subtree in the replacement node to reference the right subtree of the node to be deleted.
E) Set the reference to the left subtree in the replacement node to reference the left subtree of the node to be deleted.

Write method deleteNode, which takes as its argument the value to delete.  Method deleteNode should locate in the tree node containing the value to delete and use the algorithms discussed here to delete the node.  If the value is not found in the tree, the method should display a message saying so.  Modify the program of Figs. 21.15 and 21.16 to use this method.  After deleting an item, call the methods inorderTraversal, preorderTraversal, and postorderTraversal to confirm that the delete operation was performed correctly.

My notes: For my implementation I used five terms.  Castaway is the name of the node to be deleted.  Parriarch is the parent of castaway.  Adoptee is the name of the child node of castaway which will become the replacement child for castaway.  Orphan is the name of the child which will have to find a new parent in the adoptee tree.  Foster is the name of the new parent for orphan.
 */

class Main{
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();

        System.out.printf("%nCase 0 - part 0: Tree is null (50)%n");
        tree.deleteNode(50);

        createTree(tree);

        System.out.printf("%n%nCase 0 - part 1: Value (1) not in tree%n");
        tree.deleteNode(1);
        System.out.println();
        tree.inorderTraversal();

        System.out.printf("%n%nCase 1: Castaway (16) is root %n");
        tree.deleteNode(16);
        tree.inorderTraversal();
        tree.insertNode(16);

        System.out.printf("%n%nCase 2: Castaway (2) has no children %n");
        tree.deleteNode(2);
        tree.inorderTraversal();
        tree.insertNode(2);

        System.out.printf("%n%nCase 3: Castaway (2) has no orphan %n");
        tree.insertNode(1);
        tree.deleteNode(2);
        tree.inorderTraversal();
        tree.deleteNode(1);
        tree.insertNode(2);

        System.out.printf("%n%nCase 4: Castaway (8) has two children%n");
        tree.deleteNode(8);
        tree.inorderTraversal();
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