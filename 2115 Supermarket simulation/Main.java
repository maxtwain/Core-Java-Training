/*
Write a program that simulates a checkout line at a supermarket.  The line is a queue object.  Customers (i.e., customer objects) arrive at random integer intervals of from 1 to 4 minutes.  Also, each customer is serviced at random integer intervals of from 1 to 4 minutes.  Obviously, the rates need to be balanced.  If the average arrival rate is larger than the average service rate, the queue will grow infinitely.  Even with "balanced" rates, randomness can still cause long lines.  Run the supermarket simulation for a 12 hour day (720 minutes), using the algorithm in Fig. 21.21.  Then answer each of the following:

A) What is the maximum number of customers in the queue at any time?
B) What is the longest wait any one customer experiences?
C) What happens if the arrival interval is changed from 1 to 4 minutes to 1 to 3 minutes?
 */

class Main{
    public static void main(String[] args){

        CheckoutSimulation simulation = new CheckoutSimulation(1, 4, 1, 4, 720);

        simulation.printResult();

    }
}