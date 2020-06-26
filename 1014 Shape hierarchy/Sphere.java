public class Sphere extends ThreeDimensionalShape{
	private double area;
	private double volume;
	
	public Sphere(double area, double volume) {
		this.area = area;
		this.volume = volume;
	}
	public Sphere() {
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