/*
Stacks are used by compilers to help in the process of evaluating expressions and generating machine language code.  In this and the next exercise, we investigate how compilers evaluate arithmetic expressions consisting only of constants, operators and parentheses.
Humans generally write expressions like 3 + 4 and 7 / 9 in which the operator (+ or / here) is written between its operands - this is called infix notation.  Computers "prefer" postfix notation, in which the operator is written to the right of its two operands.  The preceding infix expressions would appear in postfix notation as 3 4 + and 7 9 /, respectively.
To evaluate a complex infix expression, a compiler would first convert the expression to postfix notation and evaluate the postfix version.  Each of these algorithms requires only a single left to right pass of the expression.  Each algorithm uses a stack object in support of its operation, but each uses the stack for a different purpose.
In this exercise, you'll write a Java version of the infix to postfix conversion algorithm.  In the next exercise, you'll write a Java version of the postfix expression evaluation algorithm.  In a later exercise, you'll discover that code you write in this exercise can help you implement a complete working compiler.
Write class InfixToPostfixConverter to convert an ordinary infix arithmetic expression (assume a valid expression is entered) with single digit integers such as

(6 + 2) * 5 - 8 / 4

to a postfix expression.  The postfix version (no parentheses are needed) of this infix expression is

6 2 + 5 * 8 4 / -

The program should read the expression into StringBuffer infix and use the stack class implemented in this chapter to help create the postfix expression in StringBuffer postfix.  The algorithm for creating a postfix expression is shows in Fig. 21.19.

-------------------------------------------------
Push a left parenthesis '(' onto the stack.

Append a right parenthesis ')' to the end of infix.

While the stack is not empty, read infix from left to right and do the following:

    If the current character in infix is a digit, append it to postfix.

    If the current character in infix is a left parenthesis, push it onto the stack.

    If the current character in infix is an operator.

        Pop operators (if there are any) at the top of the stack while they have equal or higher precedence than the current operator, and append the popped operators to postfix.

        Push the current character in infix onto the stack.

    If the current character in infix is a right parenthesis:

        Pop operators from the top of the stack and append them to postfix until a left parenthesis is at the top of the stack.

        Pop (and discard) the left parenthesis from the stack.
--------------------------------------------------

The following arithmetic operations are allowed in an expression:
+ addition
- subtraction
* multiplication
/ division
^ exponentiation
% remainder

The stack should be maintained with stack nodes, each containing data and a reference to the next stack node.  Some methods you may want to provide are as follows:
A) Method convertToPostfix, which converts the infix expression to postfix notation.
B) Method isOperator, which determines whether c is an operator.
C) Method precedence, which determines whether the precedence of operator1 (from the infix expression) is less than, equal to, or greater than that of operator2 (from the stack).  The method returns true if operator1 has lesser precedence than operator 2.  Otherwise, false is returned.
D) Method peek (this should be added to the stack class), which returns the top value of the stack without popping the stack.
 */

class Main{
    public static void main(String[] args){
        StringBuffer infix = new StringBuffer("(6 + 2) * 5 - 8 / 4");
        InfixToPostfixConverter convert = new InfixToPostfixConverter(infix);
        convert.printFix();
    }
}