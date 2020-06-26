/*
The output of Fig. 16.14 shows that PriorityQueue orders Double elements in ascending order.  Rewrite Fig. 16.14 so that it orders Double elements in descending order (i.e. 9.8 should be the highest priority element rather than 3.2).
 */

import java.util.Collections;
import java.util.PriorityQueue;

class Main{
    public static void main(String[] args){
        PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3.2);
        queue.offer(9.8);
        queue.offer(5.4);

        System.out.print("Polling from queue: ");

        while (queue.size() > 0){
            System.out.printf("%.1f ", queue.peek());
            queue.poll();
        }
    }
}