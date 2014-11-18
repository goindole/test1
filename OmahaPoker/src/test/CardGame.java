package test;

import java.util.HashMap;
import java.util.Map;

import test.model.AbstractHolder;
import test.model.Card;

public class CardGame {
	private Map<String, String> cardNameMap = null;

	public CardGame() {
		String[] cards = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
		String[] cardNames = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		cardNameMap = new HashMap<String, String>();

		for (int i = 0; i < cards.length; i++) {
			cardNameMap.put(cards[i], cardNames[i]);
		}

	}

	public void parseCards(String cardString, AbstractHolder holder) {
		if(cardString != null) {
			String[] cards = cardString.split("-");
			for(String sCard : cards) {
				Card card = new Card(sCard);
				holder.addCard(card);
			}
		}
	}
	
	public void getRank() {
		
	}

}
