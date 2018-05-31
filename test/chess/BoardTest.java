package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;

public class BoardTest {
	Board board;
	String returnLine = System.getProperty("line.separator");

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void create() throws Exception {
		Piece white = Piece.createWhitePawn();
		board.addWhitePawn(white);
		assertEquals(1, board.whitePawnSize());
		assertEquals(white, board.findWhitePawn(0));

		Piece black = Piece.createBlackPawn();
		board.addBlackPawn(black);
		assertEquals(1, board.blackPawnSize());
		assertEquals(black, board.findBlackPawn(0));
	}

	@Test
	public void boardInitialize() throws Exception {
		board.initialize();
		assertEquals(8, board.whitePawnSize());
		assertEquals(8, board.blackPawnSize());
		assertEquals("pppppppp", board.getWhitePawnsResult());
		assertEquals("PPPPPPPP", board.getBlackPawnsResult());
	}

	@Test
	public void show() throws Exception {
		board.initialize();
		assertEquals(32, board.pieceCount());
		String blankRank = appendNewLine("........");
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}
}
