package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public ArrayList<Card> drawCards(int number) {
		ArrayList<Card> drawn = new ArrayList<Card>();

		for (int i = 0; i<number; i++) {
			Card topCard = cards.get(0);
			cards.remove(0);
			drawn.add(topCard);
		}
		
		return drawn;
	}
	
	public ArrayList<Card> drawOpener() {
		ArrayList<Card> hand = drawCards(7);
		int numberOfLandsInHand = 0;
		for (Card card : hand) {
			if (card instanceof Land) {
				numberOfLandsInHand++;
			}
		}
		if (numberOfLandsInHand > 5 || numberOfLandsInHand < 2) {
			cards.addAll(hand);
			shuffle();
			return mulliganTo6();
		}
		return hand;
	}
	
	public ArrayList<Card> mulliganTo6() {
		ArrayList<Card> hand = drawCards(6);
		int numberOfLandsInHand = 0;
		for (Card card : hand) {
			if (card instanceof Land) {
				numberOfLandsInHand++;
			}
		}
		if (numberOfLandsInHand == 0) {
			cards.addAll(hand);
			shuffle();
			return drawCards(5);
		}
		return hand;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void putCardOnBottom(Card card) {
		cards.add(card);
	}
	
	public void addCardsToDeck(Card card, int number) {
		for (int i = 0; i<number; i++) {
			cards.add(card);
		}
	}
	
	public int count() {
		return cards.size();
	}
	
	public Card searchForCard(Card card) {
		if (cards.contains(card)) {
			cards.remove(card);
			Collections.shuffle(cards);
			return card;
		}
		return null;
	}
}
