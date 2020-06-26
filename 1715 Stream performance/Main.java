/*
Answer the following questions with regard to the stream pipeline in Fig 17.7

A) How many times does the filter operation call its lambda argument?

Answer: Ten

B) How many times does the map operation call its lambda argument?

Answer: Five

C) If you reverse the filter and map operations in the stream pipeline, how many times does the map operation call its lambda argument?

Answer: Ten

My notes: I answered these questions in intelliJ due to their being out of sensible order in the Exercises section.

 */

import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args){
        System.out.printf(
                "Sum of the triples of the even ints from 2 through 10 is: %d%n",
                IntStream.rangeClosed(1, 10)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 3)
                .sum());
    }
}