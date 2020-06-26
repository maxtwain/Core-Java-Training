public class IntegerSet{
	private static final int SIZE = 100;
	private boolean[] set = new boolean[SIZE];
	
	public IntegerSet() {
		for (int i = 0; i < SIZE; ++i) {
			set[i] = false;
		}
	}
}