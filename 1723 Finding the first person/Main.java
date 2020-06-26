/*
Create a collection of Person objects in which each Person has a firstName and a lastName.  Use streams to locate the first Person object containing the last name Jones.  Ensure that several Person objects in your collection have that last name.
 */

import java.util.Arrays;
import java.util.List;

class Main{
    public static void main(String[] args){
        Person[] people = {
                new Person("Joe", "Martins"),
                new Person("Ralph", "Burges"),
                new Person("Jacob", "Jones"),
                new Person("Samuel", "Martins"),
                new Person("Orlando", "Martins"),
                new Person("Iola", "Jones"),
                new Person("Ulis", "Montgomery"),
                new Person("Thresh", "Jones")
        };

        List<Person> list = Arrays.asList(people);

        System.out.printf("The first person in the list with the last name Jones is %s",
            list.stream()
                    .filter(person -> person.getLastName().matches("Jones"))
                    .findFirst()
                    .get()
        );
    }
}