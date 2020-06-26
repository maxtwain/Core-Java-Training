/*
Write a program that inputs a line of text and uses a stack to display the words of the line in reverse order.
 */

class Main{
    public static void main(String[] args){
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String[] parsed = sentence.split(" ");
        NStack<String> nList = new NStack<>("nList");
        for(String s:parsed){
            nList.insert(s);
        }

        nList.print();
    }
}