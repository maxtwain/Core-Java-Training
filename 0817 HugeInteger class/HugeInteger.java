public class HugeInteger{
	private static final int SIZE = 40;
	// num[0] holds the ones.  num[1] holds tens.  num[2] holds hundreds.
	private int[] num = new int[SIZE];
	
	public HugeInteger(String in) {
		if (in.length() > num.length) {
			throw new IllegalArgumentException("string size must be 0-39");
		}
		for (int i = 0; i < in.length(); ++i) {
			num[in.length() - 1 - i] = in.charAt(i) - 48;
		}
	}
	
	public HugeInteger() {}
	
	public void parse(String in) {
		if (in.length() > SIZE) {
			throw new IllegalArgumentException("string size must be 0-39");
		}
		for (int i = 0; i < SIZE; ++i) {
			num[in.length() - 1 - i] = in.charAt(i) - 48;
		}
	}
	
	public String toString() {
		String ret = "";
		int i = num.length - 1;
		for (; num[i] == 0; --i) {
			if (i == 0) {
				return "0";
			}
		}
		for (; i >= 0; --i) {
			ret += num[i];
		}
		return ret;
	}
	
	public int getInt(int index) {
		return num[index];
	}
	public void setInt(int index, int value) {
		num[index] = value;
	}
	
	public void add(HugeInteger addend) {
		// index of largest character
		int numInd = num.toString().length() - 1;
		int addInd = addend.toString().length() - 1;
		int maxInd = numInd > addInd ? numInd : addInd;
		
		int carry = 0;
		for (int i = 0; i <= maxInd || carry > 0; ++i) {
			if (i == maxInd && addend.getInt(i) + carry > 9) {
				throw new IllegalArgumentException("add overflow");
			}
			num[i] += addend.getInt(i) + carry;
			if (carry > 0) {
				carry = 0;
			}
			while (num[i] > 9) {
				num[i] -= 10;
				++carry;
			}
		}
	}
	
	// because of the int[] design of this class, there is no way to signify a negative number.  This method is capable of doing negative calculation, but the result can't actually show this.
	public void subtract(HugeInteger subtrahend) {
		if (this.isGreaterOrEqual(subtrahend)) {
			int numInd = num.toString().length() - 1;
			for (int i = 0; i < numInd; ++i) {
				while (num[i] - subtrahend.getInt(i) < 0) {
					num[i] += 10;
					--num[i + 1];
				}
				num[i] -= subtrahend.getInt(i);
			}
		}
		else {
			int subInd = subtrahend.toString().length() - 1;
			HugeInteger copy = new HugeInteger();
			for (int i = 0; i < subInd; ++i) {
				copy.setInt(i, subtrahend.getInt(i));
			}
			for (int i = 0; i < subInd; ++i) {
				while (copy.getInt(i) - num[i] < 0) {
					copy.setInt(i, copy.getInt(i) + 10);
					copy.setInt(i + 1, copy.getInt(i + 1) - 1);
				}
				num[i] = copy.getInt(i) - num[i];
			}
		}
	}
	
	public boolean isEqual(HugeInteger compare) {
		for (int i = 0; i < num.length; ++i) {
			if (num[i] != compare.getInt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isGreater(HugeInteger compare) {
		// index of largest character
		int numInd = num.toString().length() - 1;
		int comInd = compare.toString().length() - 1;
		int maxInd = numInd > comInd ? numInd : comInd;
		
		for (; maxInd >= 0; --maxInd) {
			if (num[maxInd] > compare.getInt(maxInd)) {
				return true;
			}
			else if (num[maxInd] < compare.getInt(maxInd)) {
				return false;
			}
		}
		return false;
	}
	
	public boolean isLesser(HugeInteger compare) {
		// index of largest character
		int numInd = num.toString().length() - 1;
		int comInd = compare.toString().length() - 1;
		int maxInd = numInd > comInd ? numInd : comInd;
		
		for (; maxInd >= 0; --maxInd) {
			if (num[maxInd] < compare.getInt(maxInd)) {
				return true;
			}
			else if (num[maxInd] > compare.getInt(maxInd)) {
				return false;
			}
		}
		return false;
	}
	
	public boolean isGreaterOrEqual(HugeInteger compare) {
		// index of largest character
		int numInd = num.toString().length() - 1;
		int comInd = compare.toString().length() - 1;
		int maxInd = numInd > comInd ? numInd : comInd;
		
		for (; maxInd >= 0; --maxInd) {
			if (num[maxInd] > compare.getInt(maxInd)) {
				return true;
			}
			else if (num[maxInd] < compare.getInt(maxInd)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isLesserOrEqual(HugeInteger compare) {
		// index of largest character
		int numInd = num.toString().length() - 1;
		int comInd = compare.toString().length() - 1;
		int maxInd = numInd > comInd ? numInd : comInd;
		
		for (; maxInd >= 0; --maxInd) {
			if (num[maxInd] < compare.getInt(maxInd)) {
				return true;
			}
			else if (num[maxInd] > compare.getInt(maxInd)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isZero() {
		for (int i = 0; i < num.length; ++i) {
			if (num[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	

}