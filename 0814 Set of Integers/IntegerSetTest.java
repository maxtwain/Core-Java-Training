/*
 * Provide the following methods: 
 * 
 * The static method union creates a set that's the set theoretic union of two existing sets( i.e., an element of the new set's array is set to true if that element is true in either or both of the existing sets - otherwise, the new set's element is set to false).  
 * 
 * The static method intersection creates a set which is the set theoretic intersection of two existing sets (i.e., an element of the new set's array is set to false if that element is false in either or both of the existing sets - otherwise, the new set's element is set to true).  
 * 
 * Method insertElement inserts a new integer k into a set (by setting a[k] to true).  
 * 
 * Method delete Element deletes integer m (by setting a[m] to false).  
 * 
 * Method toString returns a String containing a set as a list of numbers separated by spaces.  Include only those elements that are present in the set.  Use --- to represent an empty set.  
 * 
 * Method isEqualTo determines whether two sets are equal.  
 * 
 * Write a program to test class IntegerSet.  Instantiate several IntegerSet objects.  Test that all your methods work properly.
 */

public class IntegerSetTest{
	public static void main(String[] args) {
		IntegerSet set0 = new IntegerSet();
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set0.insertElement(5);
		set0.insertElement(7);
		set0.insertElement(9);
		set0.insertElement(11);
		System.out.printf("set0.toString() = %s%n", set0.toString());
		
		set1.insertElement(5);
		set1.insertElement(7);
		
		set2 = IntegerSet.union(set0, set1);
		System.out.printf("untion(set0, set1) = %s%n", set2.toString());
		
		set2 = IntegerSet.intersection(set0, set1);
		System.out.printf("intersection(set0, set1) = %s%n", set2.toString());
		
		set0.deleteElement(11);
		System.out.printf("set0.deleteElement(11) = %s%n", set0.toString());
		
		System.out.printf("set0.isEqual(set1) = %b%n", set0.isEqual(set1));
		set0.deleteElement(9);
		System.out.printf("set0.isEqual(set1) = %b%n", set0.isEqual(set1));
	}
}