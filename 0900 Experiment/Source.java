

public class Source{
	public static void main(String[] args) {
		
	}
	
	public static double getAngle(int x, int y) {
		int xM = 0;
		int yM = 0;
		
		double angle = 0;
		
		double adj = x - xM;
		double opp = y - yM;
		double hyp = Math.sqrt(Math.pow(adj, 2) + Math.pow(opp, 2));
		
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
	
	public static void printAngles() {
		System.out.printf("Angle of (1, 0) = %f%n", getAngle(1, 0));
		System.out.printf("Angle of (0, 1) = %f%n", getAngle(0, 1));
		System.out.printf("Angle of (-1, 0) = %f%n", getAngle(-1, 0));
		System.out.printf("Angle of (0, -1) = %f%n", getAngle(0, -1));
		System.out.println();
		
		System.out.printf("Angle of (1, 1) = %f%n", getAngle(1, 1));
		System.out.printf("Angle of (-1, 1) = %f%n", getAngle(-1, 1));
		System.out.printf("Angle of (-1, -1) = %f%n", getAngle(-1, -1));
		System.out.printf("Angle of (1, -1) = %f%n", getAngle(1, -1));	
	}
}