/*
Modify Figs. 21.15 and 21.16 to allow the binary tree to contain duplicates.
 */

import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        for(int i = 1; i <= 10; i++){
            int value = randomNumber.nextInt(10);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
    }
}