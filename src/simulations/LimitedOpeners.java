package simulations;

import java.util.Arrays;
import java.util.Collections;

import model.Card;
import model.Deck;

public class LimitedOpeners extends AbstractSimulation {
	
	public static void main(String[] args) {
		int[] landsInOpener = new int[8];
		for (int i = 0; i < numberOfIterations; i++) {
			int result = iteration();
			landsInOpener[result] = landsInOpener[result] + 1;
		}
		System.out.println(Arrays.toString(landsInOpener));
	}
	
	public static int iteration() {
		deck = buildDeck();
		hand = deck.drawCards(7);
		return Collections.frequency(hand, new Card("Land"));
	}
	
	public static Deck buildDeck() {
		Deck deck = new Deck();
		deck.addCardsToDeck(new Card("Land"), 16);
		deck.addCardsToDeck(new Card("Spell"), 24);
		deck.shuffle();
		
		return deck;
	}
}
