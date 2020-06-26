public class Record{
	private double time;
	private double rate;
	private double gross;
	
	Record(double time, double rate){
		this.time = time;
		this.rate = rate;
		setGross(time, rate);
	}
	
	public void setTime(double time) {
		this.time = time;
		setGross(time, rate);
	}
	public void setRate(double rate) {
		this.rate = rate;
		setGross(time, rate);
	}
	private void setGross(double time, double rate) {
		if(time > 40) {
			this.gross = 40.0 * rate + (time - 40.0) * rate * 1.5;
		}
		else {
			this.gross = time * rate;
		}
	}
	
	public double getTime() {
		return this.time;
	}
	public double getRate() {
		return this.rate;
	}
	public double getGross() {
		return this.gross;
	}
	
}