package test.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card> {
	private String								suit	= null;
	private String								rank	= null;

	private static final Map<String, Integer>	rankMap;
	static {
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("2", 2);
		aMap.put("3", 3);
		aMap.put("4", 4);
		aMap.put("5", 5);
		aMap.put("6", 6);
		aMap.put("7", 7);
		aMap.put("8", 8);
		aMap.put("9", 9);
		aMap.put("T", 10);
		aMap.put("J", 11);
		aMap.put("Q", 12);
		aMap.put("K", 13);
		aMap.put("A", 14);
		rankMap = Collections.unmodifiableMap(aMap);
	}
	private static final Map<String, String>	rankNameMap;
	static {
		Map<String, String> aMap = new HashMap<String, String>();
		aMap.put("2", "2");
		aMap.put("3", "3");
		aMap.put("4", "4");
		aMap.put("5", "5");
		aMap.put("6", "6");
		aMap.put("7", "7");
		aMap.put("8", "8");
		aMap.put("9", "9");
		aMap.put("T", "10");
		aMap.put("J", "Jack");
		aMap.put("Q", "Queen");
		aMap.put("K", "King");
		aMap.put("A", "Ace");
		rankNameMap = Collections.unmodifiableMap(aMap);
	}

	public Card() {

	}

	public Card(String sCard) {

		this.rank = sCard.substring(0, 1);
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
		return String.format(" %s%s(%2d)", this.rank, this.suit, getRankNumber());
		// return this.rank + this.suit+"("+String.format(arg0,
		// arg1))getRankNumber()+")";
	}

	public boolean sameRank(Card comp) {
		if (this.rank.equals(comp.getRank())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean sameSuit(Card comp) {
		if (this.suit.equals(comp.getSuit())) {
			return true;
		} else {
			return false;
		}
	}

	public Integer getRankNumber() {
		return rankMap.get(this.rank);
	}

	public Integer getRankNumber(String rank) {
		return rankMap.get(rank);
	}

	/**
	 * rank order is high to low
	 */
	@Override
	public int compareTo(Card  cmp) {
		return -this.getRankNumber().compareTo(cmp.getRankNumber());
	}
	
	public String getName() {
		return rankNameMap.get(this.rank);
	}
}
