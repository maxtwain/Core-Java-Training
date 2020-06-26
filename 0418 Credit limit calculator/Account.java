public class Account{
	private String accNum;
	private int initBal;
	private int monCharge;
	private int monCredit;
	private int credLimit;
	
	public Account(String accNum, int initBal, int monCharge, int monCredit, int credLimit){
		this.accNum = accNum;
		this.initBal = initBal;
		this.monCharge = monCharge;
		this.monCredit = monCredit;
		this.credLimit = credLimit;
		
		if(this.initBal + this.monCharge - this.monCredit > this.credLimit) {
			System.out.printf("Account %s: Credit limit exceeded.", this.accNum);
		}
	}
	
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}
	public void setMonCharge(int monCharge) {
		this.monCharge = monCharge;
	}
	public void setMonCredit(int monCredit) {
		this.monCredit = monCredit;
	}
	public void setCredLimit(int credLimit) {
		this.credLimit = credLimit;
	}
	
	public String getAccNum() {
		return accNum;
	}
	public float getInitBal() {
		return initBal;
	}
	public float getMonCharge() {
		return monCharge;
	}
	public float getMonCredit() {
		return monCredit;
	}
	public float getCredLimit() {
		return credLimit;
	}
	
}