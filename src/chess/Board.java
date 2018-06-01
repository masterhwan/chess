package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	List<Rank> ranks = new ArrayList<>();

	public Board() {
		initialize();
	}

	public void initialize() {
		addBlackPieceRank();
		addBlackPawnsRank();
		addBlankRank();
		addWhitePawnsRank();
		addWhitePieceRank();
	}

	private void addBlankRank() {
		Rank rank = new Rank();
		rank.createBlankRank();
		ranks.add(rank);
		ranks.add(rank);
		ranks.add(rank);
		ranks.add(rank);
	}

	private void addWhitePieceRank() {
		Rank rank = new Rank();
		rank.createWhitePiecesRank();
		ranks.add(rank);

	}

	private void addBlackPieceRank() {
		Rank rank = new Rank();
		rank.createBlackPiecesRank();
		ranks.add(rank);
	}

	private void addBlackPawnsRank() {
		Rank rank = new Rank();
		rank.createBlackPawnRank();
		ranks.add(rank);
	}

	private void addWhitePawnsRank() {
		Rank rank = new Rank();
		rank.createWhitePawnRank();
		ranks.add(rank);
	}

	private String print() {
		StringBuffer bf = new StringBuffer();
		for (Rank index : ranks) {
			bf.append(index.getRankRepresentation() + returnLine);
		}
		return bf.toString();
	}

	public String showBoard() {
		return print();
	}

	public int pieceCount() {
		return ranks.size() * 8;
	}
}
