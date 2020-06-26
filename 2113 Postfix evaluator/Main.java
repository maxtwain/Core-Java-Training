/*
Write class PostfixEvaluator that evaluates a postfix expression such as

6 2 + 5 * 8 4 / -

The program should read a postfix expression consisting of digits and operators into a StringBuffer.  The program should read the expression and evaluate it (assume it's valid).  The algorithm to evaluate a postfix expression is shown in Fig. 21.20.

--------------------------------------------
Append a right parenthesis ')' to the end of the postfix expression.  When the right parenthesis character is encountered, no further processing is necessary.

Until the right parenthesis is encountered, read the expression from left to right.
    If the current character is a digit, do the following:
        Push its integer value onto the stack (the integer value of a digit character is its value in the Unicode character set minus the value of '0' in Unicode).

        Otherwise, if the current character is an operator:
            Pop the two top elements of the stack into variables x and y.
            Calculate y operator x.
            Push the result of the calculation onto the stack.

When the right parenthesis is encountered in the expression, pop the top value of the stack.  This is the result of the postfix expression.
---------------------------------------------

[Note: In lines 4-12 above (based on the sample expression at the beginning of this exercise), if the operator is '/', the top of the stack is 4 and the next element in the stack is 40, then pop 4 into x, pop 40 into y, evaluate 40 / 4, and push the result, 10, back on the stack.  This note also applies to other operators.]  The arithmetic operations allowed in an expression are:
+ addition
- subtraction
* multiplication
/ division
^ exponentiation
% remainder

The stack should be maintained using the modified stack class from Exercise 21.12.  You may want to provide the following methods:

A) Method evaluatePostfixExpression, which evaluates the postfix expression.
B) Method calculate, which evaluates the expression op1 operator op2.

My notes: Rather than make multiple classes that do related things, I have used the code from last exercise to add the functionality required for this exercise.
 */

class Main{
    public static void main(String[] args){
        FixExpression fixExpression = new FixExpression("(6 + 2) * 5 - 8 / 4");
        fixExpression.printFix();

    }
}