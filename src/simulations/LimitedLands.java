package simulations;

import java.util.Arrays;

import model.Card;
import model.Deck;

public class LimitedLands extends AbstractSimulation {
	
	public static void main(String[] args) {		
		int[] turnWhenDrawingLand = new int[25];
		for (int j = 0; j < numberOfIterations; j++) {
			int result = iteration();
			turnWhenDrawingLand[result] = turnWhenDrawingLand[result] + 1;
		}
		System.out.println(Arrays.toString(turnWhenDrawingLand));
	}
	
	public static int iteration() {
		deck = buildDeck();
		int turn = 2;
		//int landsInHand = 1;
		while(true) {
			if (deck.drawCards(1).get(0).equals(new Card("Land"))) {
				return turn;
			}
			else {
				/*if (landsInHand == 0) {
					return turn;
				}*/
				turn++;
				//landsInHand--;
			}
		}
	}
	
	public static Deck buildDeck() {
		Deck deck = new Deck();
		deck.addCardsToDeck(new Card("Land"), 9);
		deck.addCardsToDeck(new Card("Spell"), 24);
		deck.shuffle();
		
		return deck;
	}
}
