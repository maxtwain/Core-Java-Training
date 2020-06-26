

public enum TrafficLight{
	RED(5),
	GREEN(10),
	YELLOW(15);
	
	private int duration;
	
	private TrafficLight(int duration) {
		this.duration = duration;
	}
	
	public int getDur() {
		return duration;
	}
}