package chess;

import java.util.ArrayList;
import java.util.List;

import piece.BlackBishop;
import piece.BlackKing;
import piece.BlackKnight;
import piece.BlackPawn;
import piece.BlackQueen;
import piece.BlackRook;
import piece.WhiteBishop;
import piece.WhiteKing;
import piece.WhiteKnight;
import piece.WhitePawn;
import piece.WhiteQueen;
import piece.WhiteRook;

public class Rank {

	List<String> ranks = new ArrayList<String>(8);
	private String returnLine = System.getProperty("line.separator");

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

	public void drawBlackPawn() {
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
		ranks.add(new BlackPawn().getDisplay());
	}

	public void drawSpecialWhitePieces() {
		ranks.add(new WhiteRook().getDisplay());
		ranks.add(new WhiteKnight().getDisplay());
		ranks.add(new WhiteBishop().getDisplay());
		ranks.add(new WhiteQueen().getDisplay());
		ranks.add(new WhiteKing().getDisplay());
		ranks.add(new WhiteBishop().getDisplay());
		ranks.add(new WhiteKnight().getDisplay());
		ranks.add(new WhiteRook().getDisplay());
	}

	public void drawWhitePawn() {
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
		ranks.add(new WhitePawn().getDisplay());
	}

	public void drawBlank() {
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
		ranks.add(".");
	}

	public String show() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < ranks.size(); i++) {
			bf.append(ranks.get(i));
		}
		bf.append(returnLine);
		return bf.toString();
	}

}
