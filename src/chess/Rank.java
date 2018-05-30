package chess;

import java.util.ArrayList;
import java.util.List;

import piece.BlackBishop;
import piece.BlackKing;
import piece.BlackKnight;
import piece.BlackQueen;
import piece.BlackRook;

public class Rank {

	List<String> ranks = new ArrayList<String>(8);

	public int getRankCount() {
		return ranks.size();
	}

	public void drawSpecialBlackPieces() {
		ranks.add(new BlackRook().getDisplay());
		ranks.add(new BlackKnight().getDisplay());
		ranks.add(new BlackBishop().getDisplay());
		ranks.add(new BlackQueen().getDisplay());
		ranks.add(new BlackKing().getDisplay());
		ranks.add(new BlackBishop().getDisplay());
		ranks.add(new BlackKnight().getDisplay());
		ranks.add(new BlackRook().getDisplay());
	}

	public String show() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < ranks.size(); i++) {
			bf.append(ranks.get(i));
		}
		return bf.toString();
	}

}
