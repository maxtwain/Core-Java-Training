# Exercise 23.03: Self Review
##### State whether each of the following is true or false.

A) A thread is not runnable if it has terminated.

Answer: True.

B) Some operating systems use timeslicing with threads.  Therefore, they can enable threads to preempt threads of the same priority.

Answer: I don't believe this answer is strictly true or false.  Timeslicing allows a thread to be assigned the use of a processor for a designated interval of time.  Timeslicing does not dictate which thread to be dispatched.  It is thread scheduling which does this, but thread scheduling uses timeslicing to do this.  The book actually marks this as false.

C) When the thread's quantum expires, the thread returns to the running state as the operating system assigns it to a processor.

Answer: False.  When the thread's quantum expires, the thread returns to the ready state, and the operating system assigns another thread to the processor.

D) On a single processor system without timeslicing, each thread in a set of equal priority threads (with no other threads present) runs to completion before other threads of equal priority get a chance to execute.

Answer: True.