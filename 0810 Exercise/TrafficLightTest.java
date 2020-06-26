/*
 * Write an enum type TrafficLight, whose constants (RED, GREEN, YELLOW) take one parameter - the duration of the light.  Write a program to test the TrafficLight enum so that it displays the enum constants and their durations.
 */

public class TrafficLightTest{
	public static void main(String[] args) {
		TrafficLight t0 = TrafficLight.RED;
		TrafficLight t1 = TrafficLight.GREEN;
		TrafficLight t2 = TrafficLight.YELLOW;
		
		System.out.printf("t0 = %s%nt1 = %s%nt2 = %s%n", t0, t1, t2);
		System.out.printf("t0 = %d%nt1 = %d%nt2 = %d%n", t0.getDur(), t1.getDur(), t2.getDur());
	}
}