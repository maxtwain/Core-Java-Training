import java.util.Arrays;

public class QueenSet{
	public final int QNUM = 8;
	// Each index represents the position of one queen
	public int qRow[] = new int[QNUM];
	public int qCol[] = new int[QNUM];
	
	public QueenSet() {
		Arrays.fill(this.qRow, -1);
		Arrays.fill(this.qCol, -1);
	}
	
	public boolean queenAvailable() {
		for (int i = 0; i < QNUM; ++i) {
			if (this.qRow[i] == -1 && this.qCol[i] == -1) {
				return true;
			}
		}
		return false;
	}
	
	// queenAvailable must be used before this function.
	public void placeQueen(int row, int col) {
		for (int i = 0; true; ++i) {
			if (this.qRow[i] == -1 && this.qCol[i] == -1) {
				this.qRow[i] = row;
				this.qCol[i] = col;
				return;
			}
		}
	}
	
	public int getLastQueen() {
		for (int i = QNUM - 1; i >= 0; --i) {
			if(this.qRow[i] != -1 && this.qCol[i] != -1) {
				return i;
			}
		}
		return 0;
	}
}