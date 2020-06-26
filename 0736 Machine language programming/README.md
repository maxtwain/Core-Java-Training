# Special Section: Building Your Own Computer

In the next several problems, we take a temporary diversion from the world of high level language programming to "peel open" a computer and look at its internal structure.  We introduce the machine language programming and write several machine language programs.  To make this an especially valuable experience, we then build a computer (through the technique of software based simulation) on which you can execute your machine language programs.

# Exercise 7.36: Machine Language Programming

Let's create a computer called the Simpletron.  As its name implies, it's a simple machine, but powerful.  The Simpletron runs programs written in the only language it directly understands:  Simpletron Machine Language (SML).

The Simpletron contains an accumulator - a special register in which information is put before the Simpletron uses that information in calculations or examines it in various ways.  All the information in the Simpletron is handled in terms of words.  A word is a signed four digit decimal number, such as +3364, -1293, +007, and -0001.  The Simpletron is equipped with a 100 word memory and these words are referenced by their location numbers 00, 01, ..., 99.

Before running an SML program, we must load, or place, the program into memory.  The first instruction (or statement) of every SML program is always placed in location 00.  The simulator will start executing at this location.

Each instruction written in SML occupies one word of the Simpletron's memory (so instructions are signed four digit decimal numbers).  We shall assume that the sign of an SML instruction is always plus, but the sign of a data word may be either plus or minus.  Each location in the Simpletron's memory may contain an instruction, a data value used by a program, or an unused (and so undefined) area of memory.  The first two digits of each SML instruction are the operation code specifying the operation to be performed.  SML operation codes are summarized in Fig. 7.33.

The last two digits of an SML instruction are the operand - the address of the memory location containing the word to which the operation applies.  Let's consider several simple SML programs.

Operation code | Meaning
---|---
<i>Input / Output Operations:</i> | &nbsp;
final int READ = 10; | Read a word from the keyboard into a specific location in memory.
final int WRITE = 11; | Write a word from a specific location in memory to the screen.
<i>Load / Store Operation:</i> | &nbsp;
final int LOAD = 20; | Load a word from a specific location in memory into the accumulator.
final int STORE = 21; | Store a word from the accumulator into a specific location in memory.
<i>Arithmetic Operations:</i> | &nbsp;
final int ADD = 30; | Add a word form a specific location in memory to the word in the accumulator (leave the result in the accumulator).
final int SUBTRACT = 31; | Subtract a word from a specific location in memory from the word in the accumulator (leave the result in the accumulator).
final int DIVIDE = 32; | Divide a word from a specific location in memory into the word in the accumulator (leave the result in the accumulator).
final int MULTIPLY = 33; | Multiply a word from a specific location in memory by the word in the accumulator (leave the result in the accumulator).
<i>Transfer Of Control Operations:</i> | &nbsp;
final int BRANCH = 40; | Branch to a specific location in memory;
final int BRANCHNEG = 41; | Branch to a specific location in memory if the accumulator is negative.
final int BRANCHZERO = 42; | Branch to a specific location in memory if the accumulator is zero.
final int HALT = 42; | Halt.  The program has completed its task.

<strong>Fig. 7.33</strong> | Simpletron Machine Language (SML) operation codes.

The first SML program reads two numbers form the keyboard and computes and displays their sums.  The instruction +1007 reads the first number from the keyboard and places it into location 07 (which has been initialized to 0).  Then the instruction +1008 reads the next number into location 08.  The load instruction, +2007, puts the first number into the accumulator, and the add instruction, +3008, adds the second number to the number in the accumulator.  All SML arithmetic instructions leave their results in the accumulator.  The store instruction, +2109, places the result back into memory location 09, from which the write instruction, +1109, takes the number and displays it (as a signed four digit decimal number).  The halt instruction, +4300 terminates execution.
````
00	+1007	Read A
01	+1008	Read B
02	+2007	Load A
03	+3008	Add B
04	+2109	Store C
05	+1109	Write C
06	+4300	Halt
07	+0000	Variable A
08	+0000	Variable B
09	+0000	Result C
````
<strong>Fig. 7.34</strong> | SML program that reads two integers and computes their sum

The second SML program reads two numbers from the keyboard and determines and displays the larger value.  Note the use of the instruction +4107 as a conditional transfer of control, much the same as Java's if statement.
````
00	+1009	Read A
01	+1010	Read B
02	+2009	Load A
03	+3110	Subtract B
04	+4107	Branch negative to 07
05	+1109	Write A
06	+4300	Halt
07	+1110	Write B
08	+4300	Halt
09	+0000	Variable A
10	+0000	Variable B
````
<strong>Fig. 7.35</strong> | SML program that reads two integers and determines the larger.

Now write SML programs to accomplish each of the following tasks:
1. Use a sentinel controlled loop to read 10 positive numbers.  Compute and display their sum.  (My note: A sentinel controlled loop does not have a specified end such as 10.)

2. Use a counter controlled loop to read seven numbers, some positive and some negative, and compute and display their average.

3. Read a series of numbers, and determine and display the largest number.  The first number read indicates how many numbers should be processed.