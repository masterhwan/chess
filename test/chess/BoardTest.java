package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Type;

public class BoardTest {
	Board board;
	String returnLine = System.getProperty("line.separator");
	String blankRank = appendNewLine("........");

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void show() throws Exception {
		assertEquals(64, board.pieceCount());
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	@Test
	public void return_piece() throws Exception {
		assertEquals(8, board.getBlackPawnCount());
		assertEquals(2, board.getBlackPieceCount(Type.ROOK));
	}

	@Test
	public void find_piece() throws Exception {
		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
		assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
		assertEquals(Piece.createBlank(), board.findPiece("c4"));
	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}
}
