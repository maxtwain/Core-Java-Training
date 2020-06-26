public class Tetrahedron extends ThreeDimensionalShape{
	private double area;
	private double volume;
	
	public Tetrahedron(double area, double volume) {
		this.area = area;
		this.volume = volume;
	}
	public Tetrahedron() {
		this.area = input.nextDouble() * 100;
		this.volume = input.nextDouble() * 100;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public double getArea() {
		return area;
	}
	public double getVolume() {
		return volume;
	}
}