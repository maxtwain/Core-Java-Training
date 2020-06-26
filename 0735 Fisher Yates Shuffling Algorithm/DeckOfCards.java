import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
	
	private static final SecureRandom rand = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	private Card[] deck = new Card[NUMBER_OF_CARDS];
	private int currentCard = 0;
	
	public DeckOfCards() {
		
		int cardNum = 0;
		for (Suit cardSuit : Suit.values()) {
			for (Face cardFace : Face.values()) {
				deck[cardNum] = new Card(cardFace, cardSuit);
				++cardNum;
			}
		}
	}
	
	public void shuffle() {
		currentCard = 0;
		
		ArrayList<Card> temp = new ArrayList<Card>();
		for (int i = 0; i < deck.length; ++i) {
			temp.add(deck[i]);
		}
		
		for (int i = 0; i < deck.length; ++i) {
			int move = rand.nextInt(temp.size());
			deck[i] = temp.remove(move);
		}
	}
	
	public Card dealCard() {
		if (currentCard < deck.length) {
			return deck[currentCard++];
		}
		else {
			return null;
		}
	}
	
	public boolean hasPair(Card[] hand) {
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasTwoPair(Card[] hand) {
		int pair = 0;
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					++pair;
				}
			}
		}
		
		if (pair == 2) {
			return true;
		}
		return false;
	}
	
	public boolean hasThreeKind(Card[] hand) {
		int kind;
		for (int i0 = 0; i0 < hand.length - 2; ++i0) {
			kind = 1;
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					++kind;
					if (kind == 3) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean hasFourKind(Card[] hand) {
		int kind;
		for (int i0 = 0; i0 < hand.length - 3; ++i0) {
			kind = 1;
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					++kind;
					if (kind == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean hasFlush(Card[] hand) {
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getSuit() != hand[i1].getSuit()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean hasStrait(Card[] hand) {
		if (hasPair(hand)) {
			return false;
		}
		
		int min = hand[0].getInt();
		for (int i0 = 1; i0 < hand.length; ++i0) {
			if (min > hand[i0].getInt()) {
				min = hand[i0].getInt();
			}
		}
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (min + 4 < hand[i0].getInt()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasFullHouse(Card[] hand) {
		int kind;
		int kindFace = -1;
		for (int i0 = 0; i0 < hand.length - 2; ++i0) {
			kind = 1;
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					++kind;
					if (kind == 3) {
						kindFace = hand[i1].getInt();
					}
				}
			}
		}
		if(kindFace != 3) {
			return false;
		}
		
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace() &&
						kindFace != hand[i0].getInt()) {
					return true;
				}
			}
		}
		return false;
	}
	
	

}