public class Rectangle{
	private double length = 1;
	private double width = 1;
	
	public Rectangle (double length, double width) {
		if (length >= 0 && length <= 20) {
			this.length = length;
		}
		if (length >= 0 && length <= 20) {
			this.width = width;
		}
	}
	
	public void setLength(double length) {
		if (length >= 0 && length <= 20) {
			this.length = length;
		}
	}
	public void setWidth (double width) {
		if (length >= 0 && length <= 20) {
			this.width = width;
		}
	}
	
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	
	public double perimeter() {
		return 2 * (length + width);
	}
	public double area() {
		return length * width;
	}
}