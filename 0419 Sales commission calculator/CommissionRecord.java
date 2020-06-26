public class CommissionRecord{
	private double sales;
	private double earnings;
	
	public CommissionRecord(double sales) {
		this.sales = sales;
		this.earnings = 200.0 + sales * 0.09;
	}
	
	public void setSales(double sales) {
		this.sales = sales;
	}
	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
	
	public double getSales() {
		return sales;
	}
	public double getEarnings() {
		return earnings;
	}
	
	public void newSale(double sale) {
		this.sales = sale;
		this.earnings += sale * 0.09;
	}
}