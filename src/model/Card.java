package model;

public class Card { 
	public String name;
	
	public Card(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object != null && object instanceof Card) {
			Card card = (Card) object;
			if (card.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}
}
