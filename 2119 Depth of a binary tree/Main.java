/*
Modify Figs. 21.15 and 21.16 so the Tree class provides a method getDepth that determines how many levels are in the tree.  Test the method in an application that inserts 20 random integers into a Tree.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){

        Tree<Integer> tree = new Tree<>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        for(int i = 1; i <= 20; i++){
            int value = randomNumber.nextInt(20);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();

        System.out.printf("%n%nTree depth: %d%n", tree.getDepth());
    }
}