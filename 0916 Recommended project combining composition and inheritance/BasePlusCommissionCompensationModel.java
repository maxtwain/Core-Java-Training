public class BasePlusCommissionCompensationModel extends CompensationModel{
	private double grossSales;
	private double commissionRate;
	private double baseSalary;
	
	public BasePlusCommissionCompensationModel() {
		super();
	}
	
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public double baseSalary() {
		return baseSalary;
	}
	
	public double earnings() {
		return baseSalary + grossSales * commissionRate;
	}
}