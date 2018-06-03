package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessViewTest {

	String returnLine = System.getProperty("line.separator");
	String blankRank = appendNewLine("........");

	@Test
	public void chess_view() throws Exception {
		Board board = new Board();
		board.initialize();
		ChessView chessView = new ChessView(board.getRanks());
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), chessView.view());

	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}
}
