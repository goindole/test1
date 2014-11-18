package test.model;

public abstract class AbstractRank {
	public static final int	STRAIGHT_FLUSH	= 0;
	public static final int	FOUR_OF_A_KIND	= 1;
	public static final int	FULL_HOUSE		= 2;
	public static final int	FLUSH			= 3;
	public static final int	STRAIGHT		= 4;
	public static final int	THREE_OF_A_KIND	= 7;
	public static final int	TWO_PAIR		= 8;
	public static final int	ONE_PAIR		= 9;
	public static final int	HIGH_CARD		= 10;

	public abstract int getRankOrder();

	public String getRankName() {
		String out = null;
		switch (getRankOrder()) {
			case STRAIGHT_FLUSH:
				out = "Straight Flush";
				break;
			case FOUR_OF_A_KIND:
				out = "4-of-a-Kind" ;
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
				out = "3-of-a-Kind" ;
				break;
			case TWO_PAIR:
				out = "Two Pair" ;
				break;
			case ONE_PAIR:
				out = "One Pair" ;
				break;
			default:
				out = "High Card";
		}
		return out;
	}
}
