package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.model.Board;
import test.model.Hand;

public class OmahaPoker {
	static Logger logger = LoggerFactory.getLogger(OmahaPoker.class);
			
	public static void main(String args[]) throws Exception {
		logger.debug("RUN");
		
		CardGame game = new CardGame();
		String cardString1 = "Ac-Kd-Jd-3d";
		String cardString2 = "5c-5d-6c-6d";
		String cardString3 = "Ad-Kh-5s-2d-Qd";
		

//HandA:Ac-Kd-Jd-3d HandB:5c-5d-6c-6d Board:Ad-Kh-5s-2d-Qd

		Hand handA = new Hand();
		Hand handB = new Hand();
		Board board = new Board();
		game.parseCards(cardString1, handA);
		game.parseCards(cardString2, handB);
		game.parseCards(cardString3, board);
		


		logger.debug("HandA: {} => Board {}", handA.toString(), board.toString());
		logger.debug("=>CardRank  {}",  game.getHighestCardRank(handA, board));
		
//		logger.debug("HandB: {} => Board {}", handB.toString(), board.toString());
//		logger.debug("=> {}",  game.getCardRanks(handB, board));
	}

	
}
