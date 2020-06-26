/*
Modify the program of Fig. 16.17 to count the number of occurrences of each letter rather than of each word.  For example, the string "HELLO THERE" contains two H's, three E's, two L's, one O, one T, and one R.  Display the results.
 */

import java.util.*;

class Main{
    public static void main(String[] args){
        Map<Character, Integer> myMap = new HashMap <>();

        createMap(myMap);
        displayMap(myMap);
    }

    private static void createMap(Map<Character, Integer> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        input = input.toUpperCase();
        char[] charInput = input.toCharArray();

        for (char c : charInput){
            if (Character.isLetter(c)){
                if(map.containsKey(c)) {
                    int count = map.get(c);
                    map.put(c, count + 1);
                }
                else{
                    map.put(c, 1);
                }
            }
        }
    }

    private static void displayMap(Map<Character, Integer> map){
        Set<Character> keys = map.keySet();

        TreeSet<Character> sortedKeys = new TreeSet<>(keys);

        for (char key : sortedKeys) {
            System.out.printf("%-10c%10s%n", key, map.get(key));
        }

        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
