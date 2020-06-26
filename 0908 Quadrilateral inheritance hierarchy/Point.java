public class Point{
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double distance(Point point1) {
		double xDiff = point1.getX() - this.x;
		double yDiff = point1.getY() - this.y;
		return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}
	
	// returns the angle between this and given origin
	public double getAngle(Point origin) {
		double angle = 0;
		
		double adj = x - origin.getX();
		double opp = y - origin.getY();
		double hyp = distance(origin);
		
		if (adj < 0 && opp > 0) { // Q2
			angle += 90;
		}
		else if (adj <= 0 && opp <= 0) { // Q3
			angle += 180;
		}
		else if (adj > 0 && opp < 0) { // Q4
			angle += 270;
		}
		
		adj = Math.abs(adj);
		angle += Math.toDegrees(Math.acos(adj / hyp));
		
		return angle;
	}
}