package test.model;

import java.util.Collections;
import java.util.List;

public class CardRank implements Comparable<CardRank> {

	public static final int	STRAIGHT_FLUSH	= 0;
	public static final int	FOUR_OF_A_KIND	= 1;
	public static final int	FULL_HOUSE		= 2;
	public static final int	FLUSH			= 3;
	public static final int	STRAIGHT		= 4;
	public static final int	THREE_OF_A_KIND	= 7;
	public static final int	TWO_PAIR		= 8;
	public static final int	ONE_PAIR		= 9;
	public static final int	HIGH_CARD		= 10;

	private int				rank			= 99;
	private Card			higestRank		= null;
	private List<Card>		cards			= null;
	private boolean isFlush					= false;
	public CardRank(List<Card> cards) {
		this.cards = cards;
		Collections.sort(this.cards);
		higestRank = this.cards.get(0);
		parseCard();
	}

	public int getRankOrder() {
		return this.rank;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("\n>> ");
		out.append(this.cards);
		out.append(" ");
		out.append(this.getHigestRank().getName());
		out.append("-");
		out.append(this.getRankName());

		return out.toString();
	}

	public String getRankName() {
		String out = null;
		switch (getRankOrder()) {
			case STRAIGHT_FLUSH:
				out = "Straight Flush";
				break;
			case FOUR_OF_A_KIND:
				out = "4-of-a-Kind";
				break;
			case FULL_HOUSE:
				out = "Full House";
				break;
			case FLUSH:
				out = "Flush";
				break;
			case STRAIGHT:
				out = "Straight";
				break;
			case THREE_OF_A_KIND:
				out = "3-of-a-Kind";
				break;
			case TWO_PAIR:
				out = "Two Pair";
				break;
			case ONE_PAIR:
				out = "One Pair";
				break;
			default:
				out = "High Card";
		}
		return out;
	}

	/**
	 * Identify Rank !
	 * 
	 */
	private void parseCard() {
		checkPairs();
		hasFlush();
	}

	private void checkPairs() {
		boolean rv = false;
		Card onePairCard = null;
		Card secondPairCard = null;
		Card tripleCard = null;
		
		for (int c1 = 0; c1 < cards.size(); c1++) {
			Card card1 = cards.get(c1);
			for (int c2 = c1 + 1; c2 < cards.size(); c2++) {
				Card card2 = cards.get(c2);
				if (card1.sameRank(card2)) {
					
				}
				for (int c3 = c2 + 1; c3 < cards.size(); c3++) {
					Card card3 = cards.get(c3);
				}
				
			}
		}
		//setHigestRank(card1);
//		return rv;
	}

	private boolean hasTwoPair() {
		boolean rv = false;

		return rv;
	}

	private boolean has3OfaKind() {
		boolean rv = false;

		return rv;
	}

	private boolean hasStraight() {
		boolean rv = false;

		return rv;
	}

	private void hasFlush() {
		boolean isFlush = true;
		for (int c1 = 0; c1 < cards.size(); c1++) {
			Card card1 = cards.get(c1);
			for (int c2 = c1 + 1; c2 < cards.size(); c2++) {
				if(!card1.sameSuit(cards.get(c2))) {
					isFlush = false;
					break;
				}
			}
			if(!isFlush) {
				break;
			}
		}
		if(isFlush == true) {
			this.isFlush = true;
			this.rank = FLUSH;
		}
		
	}

	private boolean hasFullHouse() {
		boolean rv = false;

		return rv;
	}

	private boolean has4KindOfAKind() {
		boolean rv = false;

		return rv;
	}

	private boolean hasStraightFlush() {
		boolean rv = false;

		return rv;
	}

	public Card getHigestRank() {
		return higestRank;
	}

	public void setHigestRank(Card higestRank) {
		this.higestRank = higestRank;
	}

	@Override
	public int compareTo(CardRank cmp) {
		if(this.getRankOrder() > cmp.getRankOrder() ) {
			return 1;
		} else if(this.getRankOrder() < cmp.getRankOrder() ) {
			return -1;
		} else {
			return 0;
		}
	}
}
