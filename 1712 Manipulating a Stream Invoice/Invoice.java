public class Invoice {
   private final String partNumber; 
   private final String partDescription;
   private int quantity;
   private double pricePerItem;

   Invoice(String partNumber, String partDescription, int quantity,
      double pricePerItem) {
      if (quantity < 0) {
         throw new IllegalArgumentException("Quantity must be >= 0");
      }

      if (pricePerItem < 0.0) {
         throw new IllegalArgumentException("Price per item must be >= 0");
      }

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   } 

   String getPartNumber() {return partNumber;}

   String getPartDescription() {return partDescription;}

   void setQuantity(int quantity) {
      if (quantity < 0) {
         throw new IllegalArgumentException("Quantity must be >= 0");
      }
      this.quantity = quantity;
   } 

   int getQuantity() {return quantity;}

   void setPricePerItem(double pricePerItem) {
      if (pricePerItem < 0.0) {
         throw new IllegalArgumentException("Price per item must be >= 0");
      }

      this.pricePerItem = pricePerItem;
   } 

   double getPricePerItem() {return pricePerItem;}

   // return String representation of Invoice object
   @Override
   public String toString() {
      return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
         "invoice", "part number", getPartNumber(), getPartDescription(), 
         "quantity", getQuantity(), "price per item", getPricePerItem());
   } 

   double getInvoiceAmount() { return getQuantity() * getPricePerItem(); }
}