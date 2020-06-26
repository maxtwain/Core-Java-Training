/*
 * Create a class HugeInteger which uses a 40 element array of digits to store integers as large as 40 digits each.  Provide methods parse, toString, add, and subtract.  Method parse should receive a String, extract each digit using method charAt, and place the integer equivalent of each digit into the integer array.  For comparing HugeInteger objects, provide the following methods: isEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo, and isLessThanOrEqualTo.  Each of these is a predicate method that returns true if the relationship holds between the two HugeInteger objects and returns false if the relationship does not hold.  Provide a predicate method isZero.  If you feel ambitious, also provide methods multiply, divide, and remainder.  [Note: Primitive boolean values can be output as the word "true" or the word "false" with format specifier %b.]
 * 
 * 
 * 
 * I've done this kind of thing before, so I'll not spend more time working on the extra functions.
 */

public class HugeIntegerTest{
	public static void main(String[] args) {
		HugeInteger integer0 = new HugeInteger("0123456789012345678901234567890123456789");
		HugeInteger integer1 = new HugeInteger("12345");
		HugeInteger integer2 = new HugeInteger("111");
		HugeInteger integer3 = new HugeInteger("222");
		HugeInteger integer4 = new HugeInteger("999");
		HugeInteger integer5 = new HugeInteger("1");
		HugeInteger integer6 = new HugeInteger();
		
		System.out.printf("integer0 = %s%n", integer0.toString());
		System.out.printf("integer1 = %s%n", integer1.toString());
		System.out.printf("integer1.getInt(0) = %d%n", integer1.getInt(0));
		
		System.out.printf("%s + %s = ", integer2.toString(), integer3.toString());
		integer2.add(integer3);
		System.out.printf("%s%n", integer2.toString());
		
		System.out.printf("integer6.toString() = %s%n", integer6.toString());
		System.out.printf("integer6.isZero() = %b%n", integer6.isZero());
		System.out.printf("integer1.isZero() = %b%n", integer1.isZero());
		
		System.out.printf("%s + %s = ", integer6.toString(), integer3.toString());
		integer6.add(integer3);
		System.out.printf("%s%n", integer6.toString());
		
		System.out.printf("%s + %s = ", integer4.toString(), integer5.toString());
		integer4.add(integer5);
		System.out.printf("%s%n", integer4.toString());
		
		System.out.printf("integer0.isGreater(integer1) = %b%n", integer0.isGreater(integer1));
		System.out.printf("integer1.isGreater(integer0) = %b%n", integer1.isGreater(integer0));
		System.out.printf("integer1.isEqual(integer1) = %b%n", integer1.isEqual(integer1));
	}
}