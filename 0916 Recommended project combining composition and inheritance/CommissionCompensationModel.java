public class CommissionCompensationModel extends CompensationModel{
	private double grossSales;
	private double commissionRate;
	
	public CommissionCompensationModel() {
		super();
	}
	
	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	
	public double earnings() {
		return grossSales * commissionRate;
	}
}