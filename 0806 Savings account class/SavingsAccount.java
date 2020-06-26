public class SavingsAccount{
	static double annualInterestRate = 0.04;
	
	private double savingsBalance;
	
	public SavingsAccount(double init) {
		savingsBalance = init;
	}
	
	public double getBal() {
		return savingsBalance;
	}
	
	public double calculateMonthlyInterest() {
		double ret = savingsBalance * (1 + annualInterestRate) / 12;
		this.savingsBalance += ret;
		return ret;
	}
	
	public void modifyInterestRate(double modRate) {
		annualInterestRate = modRate;
	}
}