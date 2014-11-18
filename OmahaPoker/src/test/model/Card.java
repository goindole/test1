package test.model;

public class Card {
	private String suit = null;
	private String rank = null;

	public Card() {

	}

	public Card(String sCard) {
		
		this.rank = sCard.substring(0,1);
		this.suit = sCard.substring(1);
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return this.rank + this.suit;
	}
}
