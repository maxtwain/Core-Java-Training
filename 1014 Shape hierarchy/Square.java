public class Square extends TwoDimensionalShape {
	private double area;
	
	public Square(double area) {
		this.area = area;
	}
	public Square() {
		this.area = input.nextDouble() * 100;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
}