package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.model.AbstractHolder;
import test.model.AbstractRank;
import test.model.Board;
import test.model.Card;
import test.model.Hand;

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
	
	public AbstractRank getRank(Hand hand, Board board) {
			List<Card>	mergedCards = new ArrayList<Card>();
			mergedCards.addAll(hand.getCards());
			mergedCards.addAll(board.getCards());
			
			return null;
	}

}
