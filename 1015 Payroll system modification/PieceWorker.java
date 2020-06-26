public class PieceWorker extends Employee{
	private double wage;
	private int pieces;
	
	public PieceWorker(String firstName, String lastName, String social, int birthMonth, int birthDay, int birthYear, double wage, int pieces) {
		super(firstName, lastName, social, birthMonth, birthDay, birthYear);
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		if (pieces < 0) {
			throw new IllegalArgumentException("Pieces sold must be >= 0");
		}
		this.wage = wage;
		this.pieces = pieces;
	}
	public PieceWorker (String firstName, String lastName, String social, double wage, int pieces) {
		super(firstName, lastName, social);
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		if (pieces < 0) {
			throw new IllegalArgumentException("Pieces sold must be >= 0");
		}
		this.wage = wage;
		this.pieces = pieces;
	}
	
	public void setWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		this.wage = wage;
	}
	public void setPieces(int pieces) {
		if (pieces < 0) {
			throw new IllegalArgumentException("Pieces sold must be >= 0");
		}
		this.pieces = pieces;
	}
	
	public double getWage() {
		return wage;
	}
	public int getPieces() {
		return pieces;
	}
	
	public double earnings() {
		return wage * pieces;
	}
	
	public String toString() {
		return String.format("piece worker: %s%npiece wage: $%,.2f; pieces handled: %,d", super.toString(), getWage(), getPieces());
	}
}