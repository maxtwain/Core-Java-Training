public class Circle extends TwoDimensionalShape{
	private double area;
	
	public Circle(double area) {
		this.area = area;
	}
	public Circle() {
		this.area = input.nextDouble() * 100;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	public double getArea() {
		return area;
	}
}