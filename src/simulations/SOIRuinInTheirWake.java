package simulations;

import model.Battlefield;
import model.Card;
import model.Deck;

public class SOIRuinInTheirWake extends AbstractSimulation {

	public static void main(String[] args) {
		int success = 0;
		int failure = 0;
		int mulligansOrNoRuin = 0;
		for (int i = 0; i < numberOfIterations; i++) {
			int result = iteration();
			if (result == 0) {
				failure++;
			}
			if (result == 1) {
				success++;
			}
			if (result == 2) {
				i--;
				mulligansOrNoRuin++;
			}
		}
		System.out.println("Success = " + success);
		System.out.println("Failure = " + failure);
		System.out.println("Mulligans or no Ruin = " + mulligansOrNoRuin);
	}
	
	public static int iteration() {
		deck = buildDeck();
		battlefield = new Battlefield();
		hand = deck.drawCards(7);
		
		if (hand.contains(new Card("Forest"))) {
			if (hand.contains(new Card("Wastes"))) {
				if (hand.contains(new Card("Ruin in their Wake"))) {
					return 1;
				}
				if (deck.drawCards(1).contains(new Card("Ruin in their Wake"))) {
					return 1;
				}
				return 2;
			}
			else if (hand.contains(new Card("Evolving Wilds")) || hand.contains(new Card("Traverse the Ulvenwald"))) {
				battlefield.permanents.add(deck.searchForCard(new Card("Wastes")));
				if (hand.contains(new Card("Ruin in their Wake"))) {
					return 1;
				}
				if (deck.drawCards(1).contains(new Card("Ruin in their Wake"))) {
					return 1;
				}
				return 2;
			}
			else if (hand.contains(new Card("Oath of Nissa"))) {
				if (deck.drawCards(3).contains(new Card("Wastes"))) {
					if (hand.contains(new Card("Ruin in their Wake"))) {
						return 1;
					}
					if (deck.drawCards(1).contains(new Card("Ruin in their Wake"))) {
						return 1;
					}
					return 2;
				}
			}
			else if (hand.contains(new Card("Ruin in their Wake"))) {
				if (deck.drawCards(1).contains(new Card("Wastes"))) {
					return 1;
				}
				return 0;
			}
			else if (deck.drawCards(1).contains(new Card("Ruin in their Wake"))) {
				return 0;
			}
			else 
				return 2;
		}
		
		else if (hand.contains(new Card("Cinder Glade"))) {
			hand.addAll(deck.drawCards(1));
			if (hand.contains(new Card("Ruin in their Wake"))) {
				if (hand.contains(new Card("Wastes"))) {
					return 1;
				}
				return 0;
			}
			return 2;
		}
		
		else if (hand.contains(new Card("Evolving Wilds"))) {
			battlefield.permanents.add(deck.searchForCard(new Card("Forest")));
			hand.addAll(deck.drawCards(1));
			if (hand.contains(new Card("Ruin in their Wake"))) {
				if (hand.contains(new Card("Wastes"))) {
					return 1;
				}
				return 0;
			}
			return 2;
		}
		
		return 2;
	}
	
	public static Deck buildDeck() {
		Deck deck = new Deck();
		deck.addCardsToDeck(new Card("Ruin in their Wake"), 4);
		deck.addCardsToDeck(new Card("Traverse the Ulvenwald"), 4);
		deck.addCardsToDeck(new Card("Oath of Nissa"), 4);
		deck.addCardsToDeck(new Card("Wastes"), 5);
		deck.addCardsToDeck(new Card("Evolving Wilds"), 4);
		deck.addCardsToDeck(new Card("Forest"), 9);
		deck.addCardsToDeck(new Card("Cinder Glade"), 2);
		deck.addCardsToDeck(new Card(""), 60-deck.count());
		deck.shuffle();
		
		return deck;
	}
}
