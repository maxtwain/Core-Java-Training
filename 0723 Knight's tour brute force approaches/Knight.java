import java.util.Arrays;

// kMoveRow and kMoveCol keep track of the row and column location of available moves in these directions.  If this value is negative one, this indicates that this legal move is unavailable.
public class Knight{
	private static final int SIZE = 8;
	
	private int kRow;
	private int kCol;
	public int[] kMoveRow = new int[8];
	public int[] kMoveCol = new int[8];
	
	public Knight(int row, int col) {
		this.kRow = row;
		this.kCol = col;
		
		setKMoveSet(this.kRow, this.kCol);
	}
	
	public int getRow() {
		return this.kRow;
	}
	public int getCol() {
		return this.kCol;
	}
	
	public void setKPos(int row, int col) {
		this.kRow = row;
		this.kCol = col;
		
		setKMoveSet(this.kRow, this.kCol);
	}
	
	private void setKMoveSet(int kRow, int kCol) {
		Arrays.fill(this.kMoveRow, -1);
		Arrays.fill(this.kMoveCol, -1);
		
		if(kRow - 2 >= 0 && kCol + 1 < SIZE) {
			this.kMoveRow[0] = kRow - 2;
			this.kMoveCol[0] = kCol + 1;
		}
		if (kRow - 1 >= 0 && kCol + 2 < SIZE) {
			this.kMoveRow[1] = kRow - 1;
			this.kMoveCol[1] = kCol + 2;
		}
		if (kRow + 1 < SIZE && kCol + 2 < SIZE) {
			this.kMoveRow[2] = kRow + 1;
			this.kMoveCol[2] = kCol + 2;
		}
		if (kRow + 2 < SIZE && kCol + 1 < SIZE) {
			this.kMoveRow[3] = kRow + 2;
			this.kMoveCol[3] = kCol + 1;
		}
		if (kRow + 2 < SIZE && kCol - 1 >= 0) {
			this.kMoveRow[4] = kRow + 2;
			this.kMoveCol[4] = kCol - 1;
		}
		if (kRow + 1 < SIZE && kCol - 2 >= 0) {
			this.kMoveRow[5] = kRow + 1;
			this.kMoveCol[5] = kCol - 2;
		}
		if (kRow - 1 >= 0 && kCol - 2 >= 0) {
			this.kMoveRow[6] = kRow - 1;
			this.kMoveCol[6] = kCol - 2;
		}
		if (kRow - 2 >= 0 && kCol - 1 >= 0) {
			this.kMoveRow[7] = kRow - 2;
			this.kMoveCol[7] = kCol - 1;
		}
	}
}