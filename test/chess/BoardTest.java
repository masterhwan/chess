package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;

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
		board.initialize();
		assertEquals(64, board.pieceCount());
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	@Test
	public void return_piece() throws Exception {
		board.initialize();
		assertEquals(8, board.getBlackPawnCount());
		assertEquals(2, board.getBlackRookPieceCount());
	}

	@Test
	public void find_piece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
		assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
		assertEquals(Piece.createBlank(), board.findPiece("c4"));
	}

	@Test
	public void move() throws Exception {
		board.emptyInitialize();

		String position = "b5";
		Piece piece = Piece.createBlackRook();
		board.move(position, piece);
		assertEquals(piece, board.findPiece(position));

		position = "b6";
		piece = Piece.createBlackKing();
		board.move(position, piece);
		assertEquals(piece, board.findPiece(position));

		position = "e3";
		piece = Piece.createWhiteKing();
		board.move(position, piece);
		assertEquals(piece, board.findPiece(position));
	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}
}
