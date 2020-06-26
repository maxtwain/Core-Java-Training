public class Rational{
	private int numer;
	private int denom;
	
	public Rational() {
		this.numer = 0;
		this.denom = 1;
	}
	
	public Rational(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
		this.reduce();
	}
	
	public void reduce() {
		for (int div = 2; div <= Math.sqrt(denom); ++div) {
			while (denom % div == 0 && numer % div == 0) {
				numer /= div;
				denom /= div;
			}
		}
	}
	
	public static Rational add(Rational addend0, Rational addend1) {
		Rational sum = new Rational();
		sum.numer = addend0.numer * addend1.denom + addend1.numer * addend0.denom;
		sum.denom = addend0.denom * addend1.denom;
		sum.reduce();
		return sum;
	}
	
	public static Rational subtract(Rational minuend, Rational subrahend) {
		Rational diff = new Rational();
		diff.numer = minuend.numer * subrahend.denom - subrahend.numer * minuend.denom;;
		diff.denom = minuend.denom * subrahend.denom;
		diff.reduce();
		return diff;
	}
	
	public static Rational multiply(Rational factor0, Rational factor1) {
		Rational product = new Rational();
		product.numer = factor0.numer * factor1.numer;
		product.denom = factor0.denom * factor1.denom;
		product.reduce();
		return product;
	}
	
	public static Rational divide(Rational dividend, Rational divisor) {
		Rational quotient = new Rational();
		quotient.numer = dividend.numer * divisor.denom;
		quotient.denom = dividend.denom * divisor.numer;
		quotient.reduce();
		return quotient;
	}
	
	public String toString() {
		return String.format("%d/%d", numer, denom);
	}
	
	public String floatString(int precision) {
		double d = (double)numer / denom;
		return String.format("%." + precision + "f", d);
	}
}