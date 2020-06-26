# Exercise 23.01: Self Review

Fill in the blanks in each of the following statements.

A) A thread enters the terminated state when _.

Answer: it successfully completes its task or otherwise terminates.

B) To pause for a designated number of milliseconds and resume execution, a thread should call method \_ of class _.

Answer: sleep, Thread

C) A runnable thread can enter the _ state for a specified interval of time.

Answer: timed waiting

D) At the operating system level, the runnable state actually encompasses two separate states, \_ and _.

Answer: ready, running

E) Runnables are executed using a class that implements the _ interface.

Answer: Executor

F) ExecutorService method _ prevents the ExecutorService from accepting new tasks, but continues executing tasks that have already been submitted.

Answer: shutdown

G) In a(n) \_ relationship, the \_ generates data and stores it in a shared object, and the _ reads data from the shared object.

Answer: producer consumer, producer, consumer

H) Only one thread at a time can execute a(n) _ statement or block.

Answer: synchronized