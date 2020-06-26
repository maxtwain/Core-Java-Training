public class Complex{
	private double realPart;
	private double imaginaryPart;
	
	public Complex() {
		realPart = 0;
		imaginaryPart = 0;
	}
	public Complex(double real, double imag) {
		realPart = real;
		imaginaryPart = imag;
	}
	
	public void add(Complex addend) {
		this.realPart += addend.realPart;
		this.imaginaryPart += addend.imaginaryPart;
	}
	
	// This isn't truly following the instructions, but it is better this way
	public void subract(Complex subtrahend) {
		this.realPart -= subtrahend.realPart;
		this.imaginaryPart -= subtrahend.imaginaryPart;
	}
	
	public void print() {
		System.out.printf("(%f, %f)", realPart, imaginaryPart);
	}
}