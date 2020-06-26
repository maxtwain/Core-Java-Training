# Exercise 09: Deadlock and Indefinite Postponement

Two problems that can occur in systems that allow threads to wait are deadlock, in which one or more threads will wait forever for an event that cannot occur, and indefinite postponement, in which one or more threads will be delayed for some unpredictably long time.  Give an example of how each of these problems can occur in multithreaded programs.

Answer: Deadlock may occur when one thread waits on another thread which itself waits on the first.  Indefinite postponement may occur when a low priority thread remains low priority indefinitely.