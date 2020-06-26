public class Turtle{
		private boolean penDown;
		private int row;
		private int col;
		private Direction dir;
		
		public Turtle() {
			this.penDown = false;
			this.row = 0;
			this.col = 0;
			this.dir = Direction.NORTH;
		}
		
		public void setPenDown(boolean value) {
			this.penDown = value;
		}
		public void setRow(int value) {
			this.row = value;
		}
		public void setCol(int value) {
			this.col = value;
		}
		public void setDir(Direction value) {
			this.dir = value;
		}
		
		public boolean getPenDown() {
			return this.penDown;
		}
		public int getRow() {
			return this.row;
		}
		public int getCol() {
			return this.col;
		}
		public Direction getDir() {
			return this.dir;
		}
	}