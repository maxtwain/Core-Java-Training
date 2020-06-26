public class GasMileage{
	private int curMiles;
	private int totMiles;
	private int curGallons;
	private int totGallons;
	
	public GasMileage(int miles, int gallons) {
		this.curMiles = miles;
		this.totMiles = miles;
		this.curGallons = gallons;
		this.totGallons = gallons;
	}
	
	public void setMiles(int miles) {
		if(miles >= 0) {
			this.curMiles = miles;
			this.totMiles += miles;
		}
	}
	public void setGallons(int gallons) {
		if(gallons >= 0) {
			this.curGallons = gallons;
			this.totGallons += gallons;
		}
	}
	
	public int getCurMiles() {
		return this.curMiles;
	}
	public int getTotMiles() {
		return this.totMiles;
	}
	public int getCurGallons() {
		return this.curGallons;
	}
	public int getTotGallons() {
		return this.totGallons;
	}
	
	public float getCurMPG() {
		return (float) this.curMiles / this.curGallons;
	}
	public float getTotMPG() {
		return (float) this.totMiles / this.totGallons;
	}
}