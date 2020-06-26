public class Source{
	public static void main(String[] args) {
		// A) Use one statement to assign the sum of x and y to z, then increment x by 1
		
		int x = 0;
		int y = 1;
		
		int z = x++ + y;
		
		// B) Test whether variable count is greater than 1.  If it is, print "Count is greater than 10"
		
		int count = 11;
		if (count > 10) {
			System.out.println("Count is greater than 10");
		}
		
		// C) Use one statement to decrement the variable x by 1, then subtract it from variable total
		// and store the result in variable total
		
		int total = 0;
		
		total -= --x;
		
		// D) Calculate the remainder after q is divided by divisor, and assign the result to q.
		// Write this statement in two different ways.
		
		int q = 5;
		int divisor = 2;
		
		q %= divisor;
		q = q % divisor;
		
	}
}