package chess;

import java.util.List;

public class ChessView {
	private String returnLine = System.getProperty("line.separator");
	private List<Rank> ranks;

	public String view(Board board) {
		StringBuffer bf = new StringBuffer();
		ranks = board.getRanks();
		for (int i = 7; i >= 0; i--) {
			bf.append(ranks.get(i).getRankRepresentation() + returnLine);
		}
		return bf.toString();
	}
}
