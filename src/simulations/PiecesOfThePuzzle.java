package simulations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Card;
import model.Deck;

public class PiecesOfThePuzzle extends AbstractSimulation {
	
	public static void main(String[] args) {
		int[] numberOfHits = new int[6];
		for (int i = 0; i < numberOfIterations; i++) {
			int result = iteration();
			if (result == 6) {
				i--;
				continue;
			}
			numberOfHits[result] = numberOfHits[result] + 1;
		}
		System.out.println(Arrays.toString(numberOfHits));
	}
	
	public static int iteration() {
		deck = buildDeck();
		hand = deck.drawCards(9);
		if (Collections.frequency(hand, new Card("Land")) < 3) {
			return 6;
		}
		if (!hand.contains(new Card("Pieces of the Puzzle"))) {
			return 6;
		}
		List<Card> pieces = deck.drawCards(5);
		return Collections.frequency(pieces, new Card("Spell")) + Collections.frequency(pieces, new Card("Pieces of the Puzzle"));
	}
	
	public static Deck buildDeck() {
		Deck deck = new Deck();
		deck.addCardsToDeck(new Card("Land"), 17);
		deck.addCardsToDeck(new Card("Pieces of the Puzzle"), 4);
		deck.addCardsToDeck(new Card("Spell"), 11);
		deck.addCardsToDeck(new Card(""), 8);
		deck.shuffle();
		
		return deck;
	}

}
