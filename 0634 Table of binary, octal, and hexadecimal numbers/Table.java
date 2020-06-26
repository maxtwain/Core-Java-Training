/*
 * Write an application that displays a table of the binary, octal, and hexadecimal equivalents of the decimal numbers in the range 1 through 256.  If you aren't familiar with these number system, read online Appendix J first.
 * 
 * This exercise is not well thought out since the many ways to do octal and hex involve the coverage of subjects not yet introduced.
 */
import java.util.Formatter;

public class Table {
	public static void main(String[] args) {
		Formatter fmt = new Formatter();
		
		System.out.printf("%12s%12s%12s%12s%n", "Decimal", "Binary", "Octal", "Hex");
		for(int i = 1; i < 256; ++i) {
			System.out.printf("%12d%12d", i, binary(i));
			// fmt.format("%12x%12o%n", i, i);
			// System.out.println(fmt);
		}
		
	}
	
	public static int binary(int dec) {
		int bin = 0;
		for (int bPow = 8; bPow >= 0; --bPow) {
			if (dec / (int)Math.pow(2, bPow) > 0) {
				dec -= (int)Math.pow(2, bPow);
				bin += (int)Math.pow(10, bPow);
			}
		}
		return bin;
	}
}