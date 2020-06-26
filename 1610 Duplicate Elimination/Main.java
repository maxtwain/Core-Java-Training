/*
Write a program that reads in a series of first names and eliminates duplicates by storing them in a Set.  Allow the user to search for a first name.

My notes:  I could not get the System.in stream to clear the EOF after trying multiple ways suggested at stackoverflow.com.  I suspect I might find a solution once I learn about streams in the next chapter.  For now I just rearranged the order of create set and find key.
 */

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a name to find: ");
        String find = scanner.nextLine();

        SortedSet<String> set = new TreeSet<>();
        System.out.print("Enter a name to add: ");
        while (scanner.hasNext()){
            set.add(scanner.nextLine());
            System.out.print("Enter a name to add: ");
        }

        System.out.printf("%s%s found.%n", find, set.contains(find) ? "" : " not");

    }
}