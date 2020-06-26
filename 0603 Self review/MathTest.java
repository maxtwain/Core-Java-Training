/*
 * Write an application that tests whether 
 * the examples of the Math class method 
 * calls shows in Fig. 6.2 actually produce 
 * the indicated results.
 */

public class MathTest {
	public static void main(String[] args) {
		// Math.abs
		if(Math.abs(23.7) == 23.7) {
			System.out.println("abs true");
		}
		else {
			System.out.println("abs false");
		}
		if(Math.abs(0.0) == 0.0) {
			System.out.println("abs true");
		}
		else {
			System.out.println("abs false");
		}
		if(Math.abs(-23.7) == 23.7) {
			System.out.println("abs true");
		}
		else {
			System.out.println("abs false");
		}
		
		// Math.ceil
		if(Math.ceil(9.2) == 10.0) {
			System.out.println("ceil true");
		}
		else {
			System.out.println("ceil false");
		}
		if(Math.ceil(-9.8) == -9.0) {
			System.out.println("ceil true");
		}
		else {
			System.out.println("ceil false");
		}
		
		// Math.cos
		if(Math.cos(0.0) == 1.0) {
			System.out.println("cos true");
		}
		else {
			System.out.println("cos false");
		}
		
		// Math.exp: It is understandable that these resolve to be false due to truncation.
		if(Math.exp(1.0) == 2.71828) {
			System.out.println("exp true");
		}
		else {
			System.out.println("exp false");
		}
		if(Math.exp(2.0) == 7.38906) {
			System.out.println("exp true");
		}
		else {
			System.out.println("exp false");
		}
		
		// Math.floor
		if(Math.floor(9.2) == 9.0) {
			System.out.println("floor true");
		}
		else {
			System.out.println("floor false");
		}
		if(Math.floor(-9.8) == -10.0) {
			System.out.println("floor true");
		}
		else {
			System.out.println("floor false");
		}
		
		// Math.log
		if(Math.log(Math.E) == 1.0) {
			System.out.println("log true");
		}
		else {
			System.out.println("log false");
		}
		if(Math.log(Math.E * Math.E) == 2.0) {
			System.out.println("log true");
		}
		else {
			System.out.println("log false");
		}
		
		// Math.max
		if(Math.max(2.3, 12.7) == 12.7) {
			System.out.println("max true");
		}
		else {
			System.out.println("max false");
		}
		if(Math.max(-2.3, -12.7) == -2.3) {
			System.out.println("max true");
		}
		else {
			System.out.println("max false");
		}
		
		// Math.min
		if(Math.min(2.3, 12.7) == 2.3) {
			System.out.println("min true");
		}
		else {
			System.out.println("min false");
		}
		if(Math.min(-2.3, -12.7) == -12.7) {
			System.out.println("min true");
		}
		else {
			System.out.println("min false");
		}
		
		// Math.pow
		if(Math.pow(2.0, 7.0) == 128.0) {
			System.out.println("pow true");
		}
		else {
			System.out.println("pow false");
		}
		if(Math.pow(9.0, 0.5) == 3.0) {
			System.out.println("pow true");
		}
		else {
			System.out.println("pow false");
		}
		
		// Math.sin
		if(Math.sin(0.0) == 0.0) {
			System.out.println("sin true");
		}
		else {
			System.out.println("sin false");
		}
		
		// Math.sqrt
		if(Math.sqrt(900.0) == 30.0) {
			System.out.println("sqrt true");
		}
		else {
			System.out.println("sqrt false");
		}
		
		// Math.tan
		if(Math.tan(0.0) == 0.0) {
			System.out.println("tan true");
		}
		else {
			System.out.println("tan false");
		}
	}
}