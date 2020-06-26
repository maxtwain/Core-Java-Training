/*
 * Research the Fisher Yates shuffling algorithm online, then use it to reimplement the shuffle method in Fig 7.10.
 * 
 */
import java.util.Scanner;

public class PokerFisherYates{
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		
		int win = 0;
		for (int game = 0; game < 20; ++game) {
			deck.shuffle();
			
			Card[] dealerHand = new Card[5];
			for (int i = 0; i < 5; i++) {
				dealerHand[i] = deck.dealCard();
			}
			Card[] playerHand = new Card[5];
			for (int i = 0; i < 5; i++) {
				playerHand[i] = deck.dealCard();
			}
			
			System.out.println("Initial Player Hand.");
			printHand(deck, playerHand);
			userDiscardDraw(deck, playerHand);
			System.out.println("Final Player Hand.");
			printHand(deck, playerHand);
			
			discardDraw(deck, dealerHand);
			System.out.println("Dealer hand.");
			printHand(deck, dealerHand);
			
			switch (Winner(deck, dealerHand, playerHand)) {
			case 0:
				System.out.println("*** DEALER wins. ***");
				break;
			case 1:
				System.out.println("*** PLAYER wins. ***");
				++win;
				break;
			case 2:
				System.out.println("TIED result.");
			}
			System.out.println();
		}
		
		System.out.printf("Player wins: %d%nDealer wins: %d%n", win, 20 - win);
		
	}
	
	public static void userDiscardDraw(DeckOfCards deck, Card[] hand) {
		System.out.println("Enter 1 for yes or 0 for no.");
		for (int i = 0; i < hand.length; ++i) {
			System.out.printf("Discard %s of %s?: ", hand[i].getFace(), hand[i].getSuit());
			if (input.nextInt() == 1) {
				hand[i] = deck.dealCard();
			}
		}
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
		if (deck.hasFourKind(hand0) && deck.hasFourKind(hand1)) {
			if (highPairValue(deck, hand0) > highPairValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasFourKind(hand0)) {
			return 0;
		}
		if (deck.hasFourKind(hand1)) {
			return 1;
		}
		
		if (deck.hasFullHouse(hand0) && deck.hasFullHouse(hand1)) {
			if (threeKindValue(deck, hand0) > threeKindValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasFullHouse(hand0)) {
			return 0;
		}
		if (deck.hasFullHouse(hand1)) {
			return 1;
		}
		
		if (deck.hasFlush(hand0) && deck.hasFlush(hand1)) {
			if (highCardValue(deck, hand0) > highCardValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasFlush(hand0)) {
			return 0;
		}
		if (deck.hasFlush(hand1)) {
			return 1;
		}
		
		if (deck.hasStrait(hand0) && deck.hasStrait(hand1)) {
			if (highCardValue(deck, hand0) > highCardValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasStrait(hand0)) {
			return 0;
		}
		if (deck.hasStrait(hand1)) {
			return 1;
		}
		
		if (deck.hasThreeKind(hand0) && deck.hasThreeKind(hand1)) {
			if (threeKindValue(deck, hand0) > threeKindValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasThreeKind(hand0)) {
			return 0;
		}
		if (deck.hasThreeKind(hand1)) {
			return 1;
		}
		
		if (deck.hasTwoPair(hand0) && deck.hasTwoPair(hand1)) {
			if (highPairValue(deck, hand0) > highPairValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasTwoPair(hand0)) {
			return 0;
		}
		if (deck.hasTwoPair(hand1)) {
			return 1;
		}
		
		if (deck.hasPair(hand0) && deck.hasPair(hand1)) {
			if (highPairValue(deck, hand0) > highPairValue(deck, hand1)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		if (deck.hasPair(hand0)) {
			return 0;
		}
		if (deck.hasPair(hand1)) {
			return 1;
		}
		
		if (highCardValue(deck, hand0) > highCardValue(deck, hand1)) {
			return 0;
		}
		else {
			return 1;
		}
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
		int match = highPairValue(deck, hand);
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (match != hand[i0].getInt()) {
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
		int match = threeKindValue(deck, hand);
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (match != hand[i0].getInt()) {
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
		int pair = highPairValue(deck, hand);
		
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (hand[i0].getInt() != pair) {
				hand[i0] = deck.dealCard();
			}
		}
	}
	
	static void hasNothingDeal(DeckOfCards deck, Card[] hand) {
		int max = highCardValue(deck, hand);
		
		if (max < 7) {
			max = -1;
		}
		for (int i0 = 0; i0 < hand.length; ++i0) {
			if (hand[i0].getInt() != max) {
				hand[i0] = deck.dealCard();
			}
		}
	}
	
	// returns value of three matching cards
	static int threeKindValue(DeckOfCards deck, Card[] hand) {
		int count;
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			count = 1;
			for (int i1 = i0 + 1; i1 < hand.length; ++i1) {
				if (hand[i0].getInt() == hand[i0].getInt()) {
					++count;
					if (count == 3) {
						return hand[i0].getInt();
					}
				}
			}
		}
		return -1;
	}
	
	// does not exclude three kind
	static int highPairValue(DeckOfCards deck, Card[] hand) {
		int maxPair = -1;
		for (int i0 = 0; i0 < hand.length - 1; ++i0) {
			for (int i1 = i0; i1 < hand.length; ++i1) {
				if (hand[i0].getInt() == hand[i1].getInt() &&
						maxPair < hand[i0].getInt()) {
					maxPair = hand[i0].getInt();
				}
			}
		}
		return maxPair;
	}
	
	static int highCardValue(DeckOfCards deck, Card[] hand) {
		int max = -1;
		for (int i = 0; i < hand.length; ++i) {
			if (max < hand[i].getInt()) {
				max = hand[i].getInt();
			}
		}
		return max;
	}
}