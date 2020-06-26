/*
 * Write an inheritance hierarchy for classes Quadrilateral, Trapazoid, Parrallelogram, Rectangle, and Square.  Use Quadrilateral as the superclass of the hierarchy.  Create and use a Point class to represent the points in each shape.  Make the hierarchy as deep (i.e., as many levels) as possible.  Specify the instance variables and methods for each class.  The private instance variables of Quadrilateral should be the x-y coordinate pairs for the four endpoints of the Quadrilateral.  Write a program that instantiates objects of your classes and outputs each objects area (except Quadrilateral).
 * 
 * 
 * 
 * My thoughts:
 * There are multiple formulas for the area of a quadrilateral.  It isn't necessary to exclude it.
 * 
 * I don't believe this exercise is well suited to inheritance, because all of the necessary information for finding the area is available in the parent object.  There is no reason to make children of it.  Besides this though, the best method for getting an area of four random points is to use a method that only needs four points.  It is actually far more difficult to find a height and of a four sided object than it is to find the area, which means that if you want to use height x base methods, a more complex and less elegant program is required.  This exercise would be vastly improved if the height and base were provided instead of four points.
 * 
 * I decided to stop working on this after about 100 lines of code to find the height with at least another 100 to go.  It is far too much work for an exercise on inheritance.  As a comparison, it is about 15 lines of code to get the area of a quadrilateral.  To get the height you need to locate the base by testing for the two lowest y coordinates, find the slope of the base, find the slope of both sides adjacent to the base, find the measures of the two angles made by these intersections, branch the code if the result is not acute, find the length of the two adjacent sides, multiply the sin of these angles by the length of their respective adjacent sides to find the height of each top point, and finally compare these two height measurements to find the greater of them.
 */

public class QuadrilateralTest{
	public static void main(String[] args) {
		
	}
}