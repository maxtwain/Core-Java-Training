/*
 * Use the methods developed in Exercise 7.30 to write an application that deals two five card poker hands, evaluates each hand, and determines which is better.
 */

public class TwoHandPoker{
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
		
		switch (Winner(deck, hand0, hand1)) {
		case 0:
			System.out.println("Deck0 wins.");
			break;
		case 1:
			System.out.println("Deck1 wins.");
			break;
		case 2:
			System.out.println("Tied result.");
		}
		
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
}