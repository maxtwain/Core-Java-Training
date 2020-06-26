/*
Write a program based on the program of Figs. 21.15 and 21.16 that inputs a line of text, tokenizes it into separate words, inserts the words in a binary search tree and prints the inorder, preorder, and postorder traversals of the tree.
 */

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Tree<String> tree = new Tree<>();

        System.out.println("Enter a line of text: ");
        String inputString = new Scanner(System.in).nextLine();

        String[] inputToken = inputString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

        System.out.println("Inserting the following words: ");
        for(String s: inputToken){
            System.out.printf("%s ", s);
            tree.insertNode(s);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
    }
}