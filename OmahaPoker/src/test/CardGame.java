package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.model.AbstractHolder;
import test.model.Board;
import test.model.Card;
import test.model.CardRank;
import test.model.Hand;

public class CardGame {
	static Logger logger = LoggerFactory.getLogger(CardGame.class);
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
	
	public CardRank getHighestCardRank(Hand hand, Board board) {
		List<CardRank> cardRanks = getCardRanks( hand,  board);
		Collections.sort(cardRanks);
		logger.debug("   CardRanks  {}", cardRanks);
		
		return cardRanks.get(0);
	}
	
	/**
	 * get Rank with Hands : any two card Board : any three Card
	 * 
	 * @param hand
	 * @param board
	 */
	private  List<CardRank>   getCardRanks(Hand hand, Board board) {
		List<Card> cardsOfHand = hand.getCards();
		List<Card> cardsOfBoard = board.getCards();
		List<CardRank> cardRanks = new ArrayList<CardRank>();
		int idx = 0;
		for (int h1 = 0; h1 < cardsOfHand.size(); h1++) {
			for (int h2 = h1 + 1; h2 < cardsOfHand.size(); h2++) {
				
				for (int b1 = 0; b1 < cardsOfBoard.size(); b1++) {
					for (int b2 = b1 + 1; b2 < cardsOfBoard.size(); b2++) {
						for (int b3 = b2 + 1; b3 < cardsOfBoard.size(); b3++) {

							List<Card> mergedCards = new ArrayList<Card>();
							// from hand
							mergedCards.add(cardsOfHand.get(h1));
							mergedCards.add(cardsOfHand.get(h2));
							
							// from board
							mergedCards.add(cardsOfBoard.get(b1));
							mergedCards.add(cardsOfBoard.get(b2));
							mergedCards.add(cardsOfBoard.get(b3));
							CardRank cardRank = parseCard(mergedCards);
							cardRanks.add(cardRank);
//							logger.debug(">>{}: {}-{},{} Parse {}",idx++, h1+h2, b1+b2+b3,  mergedCards);
						}
					}
				}
			}
		}
		return cardRanks;
	}
	
	public CardRank parseCard(List<Card> mergedCards){
		CardRank cardRank = new CardRank(mergedCards);
		return cardRank;
	}
}
