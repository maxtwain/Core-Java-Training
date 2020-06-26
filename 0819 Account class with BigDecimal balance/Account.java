import java.math.BigDecimal;

public class Account {
   private String name; 
   private BigDecimal balance; 
  
   public Account(String name, double balance) {
      this.name = name;
      
      BigDecimal bigBalance = new BigDecimal(balance);
      if (bigBalance.compareTo(BigDecimal.valueOf(0.0)) >= 0) {
         this.balance = bigBalance;
      }
   }

   public void deposit(double depositAmount) {
	  BigDecimal bigDepositAmount = new BigDecimal(depositAmount);
      if (bigDepositAmount.compareTo(BigDecimal.valueOf(0.0)) > 0) {
         balance = balance.add(bigDepositAmount);
      }
   }

   public BigDecimal getBalance() {
	   return balance;
   }

   public void setName(String name) {
      this.name = name; 
   } 

   public String getName() {
      return name; 
   } 
}