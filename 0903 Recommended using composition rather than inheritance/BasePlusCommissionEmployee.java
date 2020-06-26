public class BasePlusCommissionEmployee{
   private double baseSalary;
   private CommissionEmployee comEmp;

   public BasePlusCommissionEmployee(double baseSalary, CommissionEmployee comEmp) {
      this.comEmp = comEmp;                      

      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;
   }
   
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) {                  
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }       

      this.baseSalary = baseSalary;                
   } 

   public double getBaseSalary() {return baseSalary;}

   public double earnings() {return getBaseSalary() + comEmp.earnings();}

   public String toString() {
      return String.format("%s %s%n%s: %.2f", "base-salaried",
         comEmp.toString(), "base salary", getBaseSalary());   
   }
   
   public String getFirstName() {
	   return comEmp.getFirstName();
   }
   public String getLastName() {
	   return comEmp.getLastName();
   }
   public String getSocialSecurityNumber() {
	   return comEmp.getSocialSecurityNumber();
   }
   public double getGrossSales() {
	   return comEmp.getGrossSales();
   }
   public double getCommissionRate() {
	   return comEmp.getCommissionRate();
   }
} 
