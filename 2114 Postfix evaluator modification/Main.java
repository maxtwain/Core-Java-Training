/*
Modify the postfix evaluator program of Exercise 21.13 so that it can process integer operands larger than 9.
 */

class Main{
    public static void main(String[] args){
        FixExpression fixExpression = new FixExpression("(16 + 2) * 5 - 8 / 4");
        fixExpression.printFix();

    }
}