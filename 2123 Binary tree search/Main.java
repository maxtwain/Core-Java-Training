/*
Modify class Tree of Fig. 21.15 to include method contains, which attempts to locate a specific value in a binary search tree object.  The method should take as an argument a search key to locate.  If the node containing the search key is found, the method should return a reference to that node's data; otherwise, it should return null.
 */

class Main{
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();

        createTree(tree);

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        int searchValue = 20;
        System.out.printf("%n%nTree %s %s%n", tree.contains(searchValue) != null?"contains":"does not contain", searchValue);

        searchValue = 100;
        System.out.printf("Tree %s %s%n", tree.contains(searchValue) != null?"contains":"does not contain", searchValue);
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