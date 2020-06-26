#### Special Section: Building Your Own Compiler
In Exercises 7.36-7.38, we introduced Simpletron Machine Language (SML), and you implemented a Simpletron computer simulator to execute SML programs.  In Exercises 21.30 - 21.34, we build a compiler that converts programs written in a high level programming language to SML.  This section "ties" together the entire programming process.  You'll write programs in this new high level language, compile them on the compiler you build, and run them on the simulator you built in Exercise 7.37.  You should make every effort to implement your compiler in an object oriented manner.

Before we begin building the compiler, we discuss a simple, yet powerful high level language similar to early versions of the popular language BASIC.  We call the language Simple.  Every Simple statement consist of a line number and a Simple instruction.  Line numbers must appear in ascending order.  Each instruction begins with one of the following Simple commands: rem, input, let, print, goto, if/goto, or end (see Fig. 21.25).  All commands except end can be used repeatedly.  Simple evaluates only integer expressions using the +, -, *, and / operators.  These operators have the same precedence as in Java.  Parentheses can be used to change the order of evaluation of an expression.

&nbsp;&nbsp;

<html>
<head>
<style>
#foo
table, th, td{
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    text-align: left;
}
</style>

<body>
<table style = "foo">
    <tr>
        <th>Command</th>
        <th>Example statement</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>rem</td>
        <td>50 rem this is a remark</td>
        <td>Any text following the command rem is for documentation purposes only and is ignored by the compiler.</td>
    </tr>
    <tr>
        <td>input</td>
        <td>30 input x</td>
        <td>Display a question mark to prompt the user to enter an integer.  Read that integer from the keyboard and store the integer in x.</td>
    </tr>
    <tr>
        <td>let</td>
        <td>80 let u = 4 * (j - 56)</td>
        <td>Assign u the value of 4 * (j - 56).  Note that an arbitrary complex expression can appear to the right of the equal sign.</td>
    </tr>
    <tr>
        <td>print</td>
        <td>10 print w</td>
        <td>Display the value of w.</td>
    </tr>
    <tr>
        <td>goto</td>
        <td>70 goto 45</td>
        <td>Transfer program control to line 45.</td>
    </tr>
    <tr>
        <td>if / goto</td>
        <td>35 if i == z goto 80</td>
        <td>Compare i and z for equality and transfer program control to line 80 if the condition is true; otherwise, continue execution with the next statement.</td>
    </tr>
    <tr>
        <td>end</td>
        <td>99 end</td>
        <td>Terminate program execution.</td>
    </tr>
</table>
</body>
</html>
<strong>Fig 21.25</strong> | Simple commands.

&nbsp;&nbsp;
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Our Simple compiler recognizes only lowercase letters.  All characters in a Simple file should be lowercase.  (Uppercase letters result in a syntax error unless they appear in a rem statement, in which case they are ignored.)  A variable name is a single letter.  Simple does not allow descriptive variable names, so variables should be explained in remarks to indicate their use in a program.  Simple uses only integer variables.  Simple does not have variable declarations - merely mentioning a variable name in a program causes the variable to be declared and initialized to zero.  The syntax of Simple does not allow string manipulation (reading a string, writing a string, comparing strings, and so on).  If a string is encountered in a Simple program (after a command other than rem), the compiler generates a syntax error.  The first version of our compiler assumes that Simple programs are entered correctly.  Exercise 21.33 asks the reader to modify the compiler to perform syntax error checking.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Simple uses the conditional if/goto and unconditional goto statements to alter the flow of control during a program execution.  If the condition in the if/goto statement is true, control is transferred to a specific line of the program.  The following relational and equality operators are valid in an if/goto statement: <, >, <=, >=, ==, or !=.  The precedence of these operators is the same as in Java.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Let's now consider several programs that demonstrate Simple's features.  The first program (Fig 21.26) reads two integers from the keyboard, stores the values in variables a and b, and computes and prints their sum (stored in variable c).

````
 1  10  rem     determine and print the sum of two integers
 2  15  rem
 3  20  rem     input the two integers
 4  30  input a
 5  40  input b
 6  45  rem
 7  50  rem     add integers and store result in c
 8  60  let c = a + b
 9  65  rem
10  70  rem     print the result
11  80  print c
12  90  rem     terminate program execution
13  99  end
````
<strong>Fig 21.26</strong> | Simple program that determines the sum of two integers.

&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The program of Fig. 21.27 determines and prints the larger of two integers.  The integers are input from the keyboard and stored in s and t.  The if / goto statement tests the condition s >= t.  If the condition is true, control is transferred to line 90 and s is output; otherwise, t is output and control is transferred to the end statement in line 99, where the program terminates.

````
 1  10  rem      determine and print the larger of two integers
 2  20  input s
 3  30  input t
 4  32  rem
 5  35  rem     test if s >= t
 6  40  if s >= t goto 90
 7  45  rem
 8  50  rem     t is greater than s, so print t
 9  60  print t
10  70  goto 99
11  75  rem
12  80  rem     s is greater than or equal to t, so print s
13  90  print s
14  99  end
````
<strong>Fig 21.27</strong> | Simple program that finds the larger of two integers.

&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Simple does not provide a repetition statement (such as Java's for, while, or do...while).  However, Simple can simulate each of Java's repetition statements by using the if / goto and goto statements.  Figure 21.28 uses a sentinel controlled loop to calculate the squares of several integers.  Each integer is input from the keyboard and stored in variable j.  If the value entered is the sentinel value -9999, control is transferred to line 99, where the program terminates.  Otherwise, k is assigned the square of j, k is output to the screen, and control is passed to line 20, where the next integer is input.

````
 1  10  rem     calculate the squares of several integers
 2  20  input j
 3  23  rem
 4  25  rem     test for sentinel value
 5  30  if j == -9999 goto 99
 6  33  rem
 7  35  rem     calculate square of j and assign result to k
 8  40  let k = j * j
 9  50  print k
10  53  rem
11  55  rem     loop to get next j
12  60  goto 20
13  99  end
````
<strong>Fig 21.28</strong> | Calculate the squares of several integers.

&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Using the sample programs of Figs. 21.26-21.28 as your guide, write a Simple program to accomplish each of the following:

 1. Input three integers, determine their average, and print the result.
 2. Use a sentinel controlled loop to input 10 integers and compute and print their sum.
 3. Use a counter controlled loop to input 7 integers, some positive and some negative, and compute and print their average.
 4. Input a series of integers and determine and print the largest.  The first integer input indicates how many numbers should be processed.
 5. Input 10 integers and print the smallest.
 6. Calculate and print the sum of the even integers from 2 to 30.
 7. Calculate and print the product of the odd integers from 1 to 9.
 
 &nbsp;&nbsp;
 
###### My notes:
Part 2 asks for a sentinel controlled loop which takes 10 integers, but a sentinel controlled loop is not suited for such a limit.  A counter controlled loop would be better suited, but, as there already is a counter controlled exercise, I'll make it a hybrid of the two - a sentinel controlled loop which takes a max of 10 integers.