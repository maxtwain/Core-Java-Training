# Exercise 07: Advanced Multithreading Terms
##### Discuss each of the following terms in the context of Java's threading mechanisms

A) Synchronized

Answer: Synchronized statements are declared using the synchronized keyword.  Use of this keyword allows a thread to acquire a monitor lock on an object which prevents any other threads from accessing the object until the lock is released.

B) Wait

Answer: The wait keyword may be called on a synchronized object.  This releases the monitor lock on the object.  The thread assigned to the object goes into a wait state until a condition is satisfied while other threads may access the object.

C) Notify

Answer: Notify allows a waiting thread to transition to the runnable state again.  It is able to then reacquire a monitor lock on its synchronized object.

D) NotifyAll

Answer: NotifyAll allows all the threads waiting for a monitor lock to become eligible to reacquire the lock.  All of these threads transition to the runnable state.

E) Lock

Answer: A Lock object will not allow another thread to obtain the Lock until the first thread releases the Lock.

F) Condition

Answer: A condition object supplies a condition to be satisfied so that a thread in the waiting state may return to the runnable state.

