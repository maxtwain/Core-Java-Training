/*
 * Modify the application developed in Exercise 7.31 so that it can simulate the dealer.  The dealer's five card hand is dealt face down, so that the player cannot see it.  The application should then evaluate the dealer's hand, and, based on the quality of the hand, the dealer should draw one, two, or three more cards to replace the corresponding number of unneeded cards in the original hand.  The application should then reevaluate the dealer's hand.  [Caution: This is a difficult problem!]
 * 
 * 
 * 
 * 
 *
 */

public class PokerWithDealer{
	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		
		Card[] hand0 = new Card[5];
		for (int i = 0; i < 5; i++) {
			hand0[i] = deck.dealCard();
		}
		Card[] hand1 = new Card[5];
		for (int i = 0; i < 5; i++) {
			hand1[i] = deck.dealCard();
		}
		
		printHand(deck, hand0);
		discardDraw(deck, hand0);
		printHand(deck, hand0);
		
//		switch (Winner(deck, hand0, hand1)) {
//		case 0:
//			System.out.println("Deck0 wins.");
//			break;
//		case 1:
//			System.out.println("Deck1 wins.");
//			break;
//		case 2:
//			System.out.println("Tied result.");
//		}
		
	}
	
	public static void printHand(DeckOfCards deck, Card[] hand) {
		for (int i0 = 0; i0 < hand.length; ++i0) {
			System.out.printf("%2d of %s%n", hand[i0].getInt(), hand[i0].getSuit());
		}
		
		System.out.print("  ");
		if (deck.hasFourKind(hand)) {
			System.out.println("Four of a Kind");
		}
		else if (deck.hasFullHouse(hand)) {
			System.out.println("Full House");
		}
		else if (deck.hasFlush(hand)) {
			System.out.println("Flush");
		}
		else if (deck.hasStrait(hand)) {
			System.out.println("Strait");
		}
		else if (deck.hasThreeKind(hand)) {
			System.out.println("Three Kind");
		}
		else if (deck.hasTwoPair(hand)) {
			System.out.println("Two Pair");
		}
		else if (deck.hasPair(hand)) {
			System.out.println("A Pair");
		}
		else {
			int max = hand[0].getInt();
			for (int i0 = 1; i0 < hand.length; ++i0) {
				if (max < hand[i0].getInt()) {
					max = hand[i0].getInt();
				}
			}
			System.out.printf("%d high%n", max);
		}
		System.out.println();
	}
	
	public static int Winner(DeckOfCards deck, Card[] hand0, Card[] hand1) {
		if (deck.hasFullHouse(hand0) && deck.hasFullHouse(hand1)) {
			return 2;
		}
		if (deck.hasFullHouse(hand0)) {
			return 0;
		}
		if (deck.hasFullHouse(hand1)) {
			return 1;
		}
		
		if (deck.hasStrait(hand0) && deck.hasStrait(hand1)) {
			return 2;
		}
		if (deck.hasStrait(hand0)) {
			return 0;
		}
		if (deck.hasStrait(hand1)) {
			return 1;
		}
		
		if (deck.hasFlush(hand0) && deck.hasFlush(hand1)) {
			return 2;
		}
		if (deck.hasFlush(hand0)) {
			return 0;
		}
		if (deck.hasFlush(hand1)) {
			return 1;
		}
		
		if (deck.hasFourKind(hand0) && deck.hasFourKind(hand1)) {
			return 2;
		}
		if (deck.hasFourKind(hand0)) {
			return 0;
		}
		if (deck.hasFourKind(hand1)) {
			return 1;
		}
		
		if (deck.hasThreeKind(hand0) && deck.hasThreeKind(hand1)) {
			return 2;
		}
		if (deck.hasThreeKind(hand0)) {
			return 0;
		}
		if (deck.hasThreeKind(hand1)) {
			return 1;
		}
		
		if (deck.hasTwoPair(hand0) && deck.hasTwoPair(hand1)) {
			return 2;
		}
		if (deck.hasTwoPair(hand0)) {
			return 0;
		}
		if (deck.hasTwoPair(hand1)) {
			return 1;
		}
		
		if (deck.hasPair(hand0) && deck.hasPair(hand1)) {
			return 2;
		}
		if (deck.hasPair(hand0)) {
			return 0;
		}
		if (deck.hasPair(hand1)) {
			return 1;
		}
		return 2;
	}
	
	static void discardDraw(DeckOfCards deck, Card[] hand) {
		if (deck.hasFourKind(hand)) {
			hasFourKindDeal(deck, hand);
		}
		else if (deck.hasTwoPair(hand)) {
			hasTwoPairDeal(deck, hand);
		}
		else if (flushPursuit(hand)) {
			flushPursuitDeal(deck, hand);
		}
		else if (straitPursuit(deck, hand)) {
			straitPursuitDeal(deck, hand);
		}
		else if (deck.hasPair(hand)) {
			hasPairDeal(deck, hand);
		}
		else {
			hasNothingDeal(deck, hand);
		}
	}
	
	// determines whether to pursue a flush
	static boolean flushPursuit(Card[] hand) {
		int suitCount;
		for (int i0 = 0; i0 < 2; ++i0) {
			suitCount = 1;
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getSuit() == hand[i1].getSuit()) {
					++suitCount;
				}
			}
			if (suitCount == 4) {
				return true;
			}
		}
		return false;
	}
	
	// determines whether to pursue a strait
	static boolean straitPursuit(DeckOfCards deck, Card[] hand) {
		int min = hand[0].getInt();
		for (int i0 = 1; i0 < hand.length; ++i0) {
			if (min > hand[i0].getInt()) {
				min = hand[i0].getInt();
			}
		}
		int count = min;
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (hand[i0].getInt() == count + 1) {
				++count;
				i0 = -1;
			}
		}
		
		if (count == min + 3) {
			return true;
		}
		return false;
	}
	
	static void hasFourKindDeal(DeckOfCards deck, Card[] hand) {
		String match = hand[0].getFace();
		if (match != hand[1].getFace()) {
			if (match != hand[2].getFace()) {
				match = hand[1].getFace();
			}
			else {
				match = hand[0].getFace();
			}
		}
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (match != hand[i0].getFace()) {
				if (hand[i0].getInt() < 7) {
					hand[i0] = deck.dealCard();
					return;
				}
				else {
					return;
				}
			}
		}
	}
	
	static void straitPursuitDeal(DeckOfCards deck, Card[] hand) {
		int min = hand[0].getInt();
		for (int i0 = 1; i0 < hand.length; ++i0) {
			if (min > hand[i0].getInt()) {
				min = hand[i0].getInt();
			}
		}
		
		boolean isNum;
		int i0;
		for (int add = 0; add < 4; ++add) {
			isNum = false;
			for (i0 = 0; i0 < hand.length; ++i0) {
				if (min + add == hand[i0].getInt()) {
					isNum = true;
					break;
				}
			}
			if (isNum == false) {
				hand[i0] = deck.dealCard();
				return;
			}
		}
	}
	
	// finds spare card and deals a replacement
	static void flushPursuitDeal(DeckOfCards deck, Card[] hand) {
		if (hand[0].getSuit() == hand[1].getSuit()) {
			for (int i2 = 1; i2 < 4; ++i2) {
				if (hand[i2].getSuit() != hand[i2 + 1].getSuit()) {
					hand[i2 + 1] = deck.dealCard();
					return;
				}
			}
		}
		else if (hand[0].getSuit() != hand[2].getSuit()) {
			hand[0] = deck.dealCard();
			return;
		}
		else {
			hand[1] = deck.dealCard();
			return;
		}
	}
	
	static void hasThreeKindDeal(DeckOfCards deck, Card[] hand) {
		String match = "";
		for (int i0 = 0; i0 < hand.length - 2; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getFace() == hand[i1].getFace()) {
					match = hand[i0].getFace();
				}
			}
		}
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (match != hand[i0].getFace()) {
				hand[i0] = deck.dealCard();
			}
		}
	}
	
	static void hasTwoPairDeal(DeckOfCards deck, Card[] hand) {
		int pair0 = -1;
		int pair1 = -1;
		for (int i0 = 0; i0 < hand.length - 1; i0++) {
			for (int i1 = i0 + 1; i1 < hand.length; i1++) {
				if (hand[i0].getInt() == hand[i1].getInt()) {
					if (pair0 == -1) {
						pair0 = hand[i0].getInt();
					}
					else {
						pair1 = hand[i0].getInt();
					}
				}
			}
		}
		
		for (int i0 = 0; i0 < hand.length; i0++) {
			if (hand[i0].getInt() != pair0 || hand[i0].getInt() != pair1) {
				hand[i0] = deck.dealCard();
			}
		}
	}
	
	static void hasPairDeal(DeckOfCards deck, Card[] hand) {
		int pair = -1;
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getInt() == hand[i1].getInt()) {
					pair = hand[i0].getInt();
				}
			}
		}
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (hand[i0].getInt() != pair) {
				hand[i0] = deck.dealCard();
			}
		}
	}
	
	static void hasNothingDeal(DeckOfCards deck, Card[] hand) {
		int max = hand[0].getInt();
		for (int i0 = 1; i0 < hand.length; ++i0) {
			if (max < hand[i0].getInt()) {
				max = hand[i0].getInt();
			}
		}
		
		if (max < 7) {
			max = -1;
		}
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (hand[i0].getInt() != max) {
				hand[i0] = deck.dealCard();
			}
		}
	}
}