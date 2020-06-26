public class IntegerSet{
	private static final int SIZE = 100;
	private boolean[] set = new boolean[SIZE];
	
	public IntegerSet() {
		for (int i = 0; i < SIZE; ++i) {
			set[i] = false;
		}
	}
	
	public boolean getValue(int i) {
		return set[i];
	}
	
	public static IntegerSet union (IntegerSet addend0, IntegerSet addend1) {
		IntegerSet newSet = new IntegerSet();
		
		for (int i = 0; i < SIZE; ++i) {
			if (addend0.getValue(i)) {
				newSet.insertElement(i);
			}
			else {
				newSet.deleteElement(i);
			}
		}
		return newSet;
	}
	
	public static IntegerSet intersection (IntegerSet addend0, IntegerSet addend1) {
		IntegerSet newSet = new IntegerSet();
		
		for (int i = 0; i < SIZE; ++i) {
			if (addend0.getValue(i) && addend1.getValue(i)) {
				newSet.insertElement(i);
			}
			else {
				newSet.deleteElement(i);
			}
		}
		return newSet;
	}
	
	public void insertElement(int k) {
		set[k] = true;
	}
	
	public void deleteElement(int m) {
		set[m] = false;
	}
	
	public String toString() {
		String ret = "";
		boolean empty = true;
		for (int i = 0; i < SIZE; ++i) {
			if (set[i] == true) {
				empty = false;
				ret += i + " ";
			}
		}
		if (empty) {
			return "---";
		}
		else {
			return ret;
		}
	}
	
	public boolean isEqual(IntegerSet compare) {
		for (int i = 0; i < SIZE; ++i) {
			if (set[i] != compare.getValue(i)) {
				return false;
			}
		}
		return true;
	}
}