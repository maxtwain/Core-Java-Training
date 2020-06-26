/*
The example of Fig. 17.7 summed the triples of the even integers from 2 through 10.  We used filter and map in the stream pipeline to demonstrate both in one stream pipeline.  Reimplement Fig 17.7's stream pipeline using only map (similar to Fig 17.4).

My notes: There are a couple of ways to do this.  While still thinking of the filter process, a ternary can be used as I have done below.  Another way would be to use the range to multiply by 2 to get sequential even numbers, then multiply those by 3.
 */

import java.util.stream.IntStream;

class Main{
    public static void main(String[] args){
        System.out.printf("Sum of the triples of the even ints from 2 through 10 is: %d%n",
            IntStream.rangeClosed(1, 10)
                .map(x -> x % 2 == 0 ? x * 3 : 0)
                .sum());
    }
}