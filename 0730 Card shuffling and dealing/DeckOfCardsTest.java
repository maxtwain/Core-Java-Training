/*
 * Modify Fig 7.11 to deal a five card poker hand.  Then modify class DeckOfCards of Fig 7.10 to include methods that determine whether a hand contains
 * 
 * A) a pair
 * B) two pairs
 * C) three of a kind (e.g. three jacks)
 * D) four of a kind (e.g. four aces)
 * E) a flush (i.e. all five cards of the same suit)
 * F) a strait (i.e. five cards of consecutive face values)
 * G) a full house (i.e. two cards of one face value and three cards of another face value)
 * 
 * [Hint: Add methods getFace and getSuit to class Card of Fig 7.9]
 * 
 * 
 * 
 *Perhaps I am not understanding something, but the size of a DeckOfCards object is a constant of 52 cards.  If I make a new DeckOfCards object, it will not be a five card hand.  It will have 52 cards.  This would not be such a big deal except that the exercise instructs me to create these functions in DeckOfCards class.  If a dealt hand is not a DeckOfCards object, I can't use these functions on a hand.
 */

public class DeckOfCardsTest {
	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		Card[] hand = new Card[5];
		for (int i = 0; i < 5; i++) {
			hand[i] = myDeckOfCards.dealCard();
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.printf(" %s of %s ", hand[i].getFace(), hand[i].getSuit());
		}
		System.out.println();
		
		System.out.printf("%20s%b%n", "Has Pair: ", myDeckOfCards.hasPair(hand));
		System.out.printf("%20s%b%n", "Has Two Pair: ", myDeckOfCards.hasTwoPair(hand));
		System.out.printf("%20s%b%n", "Has Three Kind: ", myDeckOfCards.hasThreeKind(hand));
		System.out.printf("%20s%b%n", "Has Four Kind: ", myDeckOfCards.hasFourKind(hand));
		System.out.printf("%20s%b%n", "Has Flush: ", myDeckOfCards.hasFlush(hand));
		System.out.printf("%20s%b%n", "Has Strait: ", myDeckOfCards.hasStrait(hand));
		System.out.printf("%20s%b%n", "Has Full House: ", myDeckOfCards.hasFullHouse(hand));
	}
}