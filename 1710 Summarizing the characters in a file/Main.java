/*
Modify the program of Fig. 17.22 to summarize the number of occurrences of every character in the file.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException{
        Map<Character, Long> characterCounts =
                Files.lines(Paths.get("gibberish.txt"))
                        .flatMap(line -> line.replaceAll("[^a-zA-Z]", "").chars().mapToObj(ascInt -> (char)ascInt))
                        .collect(Collectors.groupingBy(Character::toLowerCase, TreeMap::new, Collectors.counting()));

        characterCounts.forEach((letter, count) -> System.out.printf("%n%C: %d", letter, count));
    }
}