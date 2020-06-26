public class Time2{
	private int second;
	
	public Time2() {
		this(0, 0, 0);
	}
	
	public Time2(int hour) {
		this(hour, 0, 0);
	}
	
	public Time2 (int hour, int minute) {
		this(hour, minute, 0);
	}
	
	public Time2(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		minute *= 60;
		hour *= 60 * 60;
		this.second = second + minute + hour;
	}
	
	public Time2(Time2 time) {
		this.second = time.second;
	}
	
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("minute must be 0-59");
		}
		
		if (second < 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		minute *= 60;
		hour *= 24 * 60;
		this.second = second + minute + hour;
	}
	
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}
		second = getMinute() * 60 + getSecond();
		second += hour * 60 * 60;
	}
	
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		second = getHour() * 60 * 60 + getSecond();
		second += minute * 60;
	}
	
	public void setSecond (int second) {
		if (second > 0 || second >= 60) {
			throw new IllegalArgumentException("second must be 0-59");
		}
		this.second = getHour() * 60 * 60 + getMinute() * 60;
		this.second += second;
	}
	
	public int getHour() {
		return second / (60 * 60);
	}
	
	public int getMinute() {
		return (second - getHour() * 60 * 60 - getSecond()) / 60;
	}
	
	public int getSecond() {
		return second % 60;
	}
	
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}
	
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12), getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
}