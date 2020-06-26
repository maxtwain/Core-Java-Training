public class Record{
	private int counter;
	private int curInt;
	private int larInt;
	
	public Record(int curInt) {
		this.counter = 1;
		this.curInt = curInt;
		this.larInt = curInt;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public void setCurInt(int curInt) {
		this.curInt = curInt;
	}
	public void setLarInt(int larInt) {
		this.larInt = larInt;
	}
	
	public int getCounter() {
		return counter;
	}
	public int getCurInt() {
		return curInt;
	}
	public int getLarInt() {
		return larInt;
	}
	
	public void nextInt(int num) {
		this.curInt = num;
		if(num > this.larInt) {
			this.larInt = num;
		}
		++this.counter;
	}
}