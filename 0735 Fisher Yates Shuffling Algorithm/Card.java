public class Card {
	private final Face face;
	private final Suit suit;
	
	public Card(Face cardFace, Suit cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	public Face getFace() {
		return this.face;
	}
	public Suit getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return face + " of " + suit;
	}
	
	public int getInt() {
		switch (this.face) {
		case Ace:
			return 1;
		case Deuce:
			return 2;
		case Three:
			return 3;
		case Four:
			return 4;
		case Five:
			return 5;
		case Six:
			return 6;
		case Seven:
			return 7;
		case Eight:
			return 8;
		case Nine:
			return 9;
		case Ten:
			return 10;
		case Jack:
			return 11;
		case Queen:
			return 12;
		case King:
			return 13;
		}
		return 13;
	}
}