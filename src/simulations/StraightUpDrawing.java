package simulations;

import model.Card;
import model.Deck;

public class StraightUpDrawing extends AbstractSimulation {

	public static void main(String args[]) {
		int numberOfSuccessHands = 0;
		for (int i = 0; i < numberOfIterations; i++) {
			numberOfSuccessHands = numberOfSuccessHands + iteration();
		}
		System.out.println(numberOfSuccessHands);
	}
	
	public static int iteration() {
		Deck deck = buildDeck();
		hand = deck.drawOpener();
		hand.addAll(deck.drawCards(2));
		
		if (hand.contains(new Card("Anticipate"))) {
			return 1;
		}
		return 0;
	}
	
	public static Deck buildDeck() {
		Deck deck = new Deck();
		deck.addCardsToDeck(new Card("Anticipate"), 6);
		deck.addCardsToDeck(new Card(""), 34);
		deck.shuffle();
		return deck;
	}
}
