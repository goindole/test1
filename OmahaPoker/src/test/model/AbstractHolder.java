package test.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractHolder {
	protected List<Card>	cards	= new ArrayList<Card>();

	public void addCard(Card card) {
		cards.add(card);
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		for (Card card : this.cards) {
			out.append(card.toString());
			out.append(", ");
		}

		return out.toString();
	}
	
	public List<Card> getCards() {
		return this.cards;
	}


}
