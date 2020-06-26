public class Invoice {
	private String partNum;
	private String partDes;
	private int quant;
	private double price;
	
	public Invoice(String partNum, String partDes, int quant, double price) {
		this.partNum = partNum;
		this.partDes = partDes;
		if(quant < 0) {
			this.quant = 0;
		}
		else {
			this.quant = quant;
		}
		if(price < 0) {
			this.price = 0.0;
		}
		else {
			this.price = price;
		}
	}
	
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	
	public void setPartDes(String partDes) {
		this.partDes = partDes;
	}
	
	public void setQuant(int quant) {
		if(quant < 0) {
			this.quant = 0;
		}
		else {
			this.quant = quant;
		}
	}
	
	public void setPrice(double price) {
		if(price < 0) {
			this.price = 0.0;
		}
		else {
			this.price = price;
		}
	}
	
	public String getPartNum() {
		return partNum;
	}
	
	public String getPartDes() {
		return partDes;
	}
	
	public int getQuant() {
		return quant;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getInvoiceAmount() {
		return this.quant * this.price;
	}
}