package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Rank> ranks = new ArrayList<>();

	public void emptyInitialize() {
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.initializeBlankLine(i));
		}
	}

	public void initialize() {
		ranks.add(Rank.initializeWhitePieces(1));
		ranks.add(Rank.initializeWhitePawns(2));
		ranks.add(Rank.initializeBlankLine(3));
		ranks.add(Rank.initializeBlankLine(4));
		ranks.add(Rank.initializeBlankLine(5));
		ranks.add(Rank.initializeBlankLine(6));
		ranks.add(Rank.initializeBlackPawns(7));
		ranks.add(Rank.initializeBlackPieces(8));
	}

	public List<Rank> getRanks() {
		return ranks;
	}
}
