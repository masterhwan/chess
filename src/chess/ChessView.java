package chess;

import java.util.List;

public class ChessView {
	String returnLine = System.getProperty("line.separator");

	private List<Rank> ranks;

	public ChessView(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public String view() {
		StringBuffer bf = new StringBuffer();
		for (int i = 7; i >= 0; i--) {
			bf.append(ranks.get(i).getRankRepresentation() + returnLine);
		}
		return bf.toString();
	}
}
