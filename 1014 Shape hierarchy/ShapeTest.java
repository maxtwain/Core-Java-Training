/*
 * Implement the Shape hierarchy shows in Fig. 9.3.  Each TwoDimensionalShape should contain method getArea to calculate the area of the two dimensional shape.  Each ThreeDimensionalShape should have methods getArea and getVolume to calculate the surface area and volume, respectively, of the three dimensional shape.  Create a program that uses an array of Shape references to objects of each concrete class in the hierarchy.  The program should print a text description of the object to which each array element refers.  Also, in the loop that processes all the shapes in the array, determine whether each shape is a TwoDimensionalShape or a ThreeDimensionalShape.  If it's a TwoDimensionalShape, display its area.  If it's a ThreeDimensionalShape, display its area and volume.
 * 
 * 
 * 
 * My notes:
 * This was an excellent exercise.
 */

public class ShapeTest{
	public static void main(String[] args) {
		Circle circle = new Circle();
		Square square = new Square();
		Triangle triangle = new Triangle();
		Cube cube = new Cube();
		Sphere sphere = new Sphere();
		Tetrahedron tetrahedron = new Tetrahedron();
		
		Shape[] shape = new Shape[6];
		
		shape[0] = circle;
		shape[1] = square;
		shape[2] = triangle;
		shape[3] = cube;
		shape[4] = sphere;
		shape[5] = tetrahedron;
		
		for (Shape currentShape : shape) {
			System.out.printf("Shape: %-12s Area: %5.2f",  currentShape.getClass().getName(), currentShape.getArea());
			if (currentShape instanceof ThreeDimensionalShape) {
				ThreeDimensionalShape castShape = (ThreeDimensionalShape) currentShape;
				System.out.printf(" Volume: %.2f",  castShape.getVolume());
			}
			System.out.println();
		}
		
	}
}