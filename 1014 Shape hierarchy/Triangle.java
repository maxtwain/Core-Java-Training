public class Triangle extends TwoDimensionalShape {
	private double area;
	
	public Triangle(double area) {
		this.area = area;
	}
	public Triangle() {
		this.area = input.nextDouble() * 100;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
}