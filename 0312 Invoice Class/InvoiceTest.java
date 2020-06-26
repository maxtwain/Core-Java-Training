/*
 * Create a class called Invoice that a hardware store might use to represent an invoice for an
 * item sold at the store.  An Invoice should include four pieces of information as instance
 * variables - a part number, a part description, a quantity of the item being purchased,
 * and a price per item.  Your class should have a constructor that initializes the four instance
 * variables.  Provide a set and a get method for each instance variable.  In addition, provide
 * a method named getInvoiceAmount that calculates the invoice amount, then returns the amount
 * as a double value.  If the quantity is not positive, it should be set to 0.  If the price per 
 * item is not positive, it should be set to 0.0.  Write a test app named InvoiceTest that 
 * demonstrates class Invoice's capabilities.
 */

public class InvoiceTest{
	public static void main(String[] args) {
		Invoice rec0 = new Invoice("j432", "blue", 5, .20);
		Invoice rec1 = new Invoice("490-43", "red", -1, -1);
		
		System.out.printf("%10s%10s%10s%10s%10s%n",
				"partNum", "partDes", "quant", "price", "inv");
		
		System.out.printf("%10s%10s%10d%10.2f%10.2f%n",
				rec0.getPartNum(), rec0.getPartDes(), rec0.getQuant(), rec0.getPrice(),
				rec0.getInvoiceAmount());
		
		System.out.printf("%10s%10s%10d%10.2f%10.2f%n",
				rec1.getPartNum(), rec1.getPartDes(), rec1.getQuant(), rec1.getPrice(),
				rec1.getInvoiceAmount());
		
		rec0.setPartNum("th#54");
		rec0.setPartDes("small");
		rec0.setQuant(39);
		rec0.setPrice(0.11);
		
		System.out.printf("%10s%10s%10d%10.2f%10.2f%n",
				rec0.getPartNum(), rec0.getPartDes(), rec0.getQuant(), rec0.getPrice(),
				rec0.getInvoiceAmount());
		
		rec0.setQuant(-1);
		rec0.setPrice(-1);
		
		System.out.printf("%10s%10s%10d%10.2f%10.2f%n",
				rec0.getPartNum(), rec0.getPartDes(), rec0.getQuant(), rec0.getPrice(),
				rec0.getInvoiceAmount());
	}
}