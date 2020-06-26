/*
 * In this chapter, we discussed the logical 
 * operators &&, &, ||, |, ^, and !.  De 
 * Morgan's laws can sometimes make it more 
 * convenient for us to express a logical 
 * expression.  These laws state that the 
 * expression !(condition1 && condition2) 
 * is logically equivalent to the expression 
 * (!condition1 || !condition2).  Also, the 
 * expression !(condition1 || condition2) is 
 * logically equivalent to the expression 
 * (!condition1 && !condition2).  Use De 
 * Morgan's laws to write equivalent 
 * expressions for each of the following, 
 * then write an application to show that 
 * both the original expression and the new 
 * expression in each case produce the same 
 * result.
 * 
 * A) !(x < 5) && !(y >= 7)
 * B) !(a == b) || !(g != 5)
 * C) !((x <= 8) && (y > 4))
 * D) !((i > 4) || (j <= 6))
 * 
 */

public class Laws{
	public static void main(String[] args) {
		int x = 4;
		int y = 1;
		int a = 9;
		int b = 8;
		int g = 2;
		int i = 0;
		int j = -1;
		
		// A) !(x < 5) && !(y >= 7)
		
		//  ) !((x < 5) || (y >= 7))
		
		if((!(x < 5) && !(y >= 7)) == (!((x < 5) || (y >= 7)))){
			System.out.println("A is equal");
		}
		
		// B) !(a == b) || !(g != 5)
		
		//  ) !((a == b) && (g != 5))
		
		if((!(a == b) || !(g != 5)) == (!((a == b) && (g != 5)))){
			System.out.println("B is equal");
		}
		
		// C) !((x <= 8) && (y > 4))
		
		//  ) !(x <= 8) || !(y > 4)
		
		if((!((x <= 8) && (y > 4))) == (!(x <= 8) || !(y > 4))){
			System.out.println("C is equal");
		}
		
		// D) !((i > 4) || (j <= 6))
		
		//  ) !(i > 4) && !(j <= 6))
		
		if((!((i > 4) || (j <= 6))) == (!(i > 4) && !(j <= 6))){
			System.out.println("D is equal");
		}
		
	}
}