/*
Write a generic class Pair which has two type parameters - F and S - each representing the type of the first and second element of the pair, respectively.  Add get and set methods for the first and second elements of the pair.  [Hint: The class header should be public class Pair<F, S>
 */

class Main{
    public static void main(String[] args){
        Pair<Integer, Double> pair = new Pair<>();
        pair.setVar0(5);
        pair.setVar1(4.45);
        System.out.printf("F = %d%nS = %f%n", pair.getVar0(), pair.getVar1());
    }
}