/*
 * Calculate the value of pi from the Leibniz series
 */

public class PiSeries{
	public static final int TERMS = 100000000;
	
	public static void main(String[] args) {
		double pi = 4.0;
		int den = 1;
		for(int i = 0; i < TERMS; ++i) {
			den += 2;
			pi -= (double)4 / den;
			den += 2;
			pi += (double)4 / den;
		}
		System.out.printf("pi = %.20f%n", pi);
	}
}                                                                                                