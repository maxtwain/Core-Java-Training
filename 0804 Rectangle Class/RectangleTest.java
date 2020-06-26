/*
 * Create a class Rectangle with attributes length and width, each of which defaults to 1.  Provide methods that calculate the rectangle's perimeter and area.  It has set and get methods for both length and width.  The set methods should verify that length and width are each floating point numbers larger than 0.0 and less than 20.0.  Write a program to test class Rectangle.
 */

class RectangleTest{
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(1, 1);
		
		System.out.printf("length = %f%nwidth = %f%nperimeter = %f%narea = %f%n", rect.getLength(), rect.getWidth(), rect.perimeter(), rect.area());
	}
}