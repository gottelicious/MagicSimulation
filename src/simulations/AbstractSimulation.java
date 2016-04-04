package simulations;

import java.util.List;

import model.Battlefield;
import model.Card;
import model.Deck;

public abstract class AbstractSimulation {
	static int numberOfIterations = 1000000;
	static Deck deck;
	static Battlefield battlefield;
	static List<Card> hand;
	
	
	public static Deck buildDeck() {
		return null;
	}
	
	public static int iteration() {
		return 0;
	}
}
