package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Color;

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

	@Test
	public void caculcatePoint() throws Exception {
		board.emptyInitialize();

		addPiece("b6", Piece.createBlackPawn());
		addPiece("a7", Piece.createBlackPawn());
		addPiece("c7", Piece.createBlackPawn());
		addPiece("d7", Piece.createBlackBishop());
		addPiece("e6", Piece.createBlackQueen());
		addPiece("b8", Piece.createBlackKing());
		addPiece("c8", Piece.createBlackRook());

		addPiece("f4", Piece.createWhiteKnight());
		addPiece("g4", Piece.createWhiteQueen());
		addPiece("f2", Piece.createWhitePawn());
		addPiece("f3", Piece.createWhitePawn());
		addPiece("h3", Piece.createWhitePawn());
		addPiece("g2", Piece.createWhitePawn());
		addPiece("e1", Piece.createWhiteRook());
		addPiece("f1", Piece.createWhiteKing());

		System.out.println(board.showBoard());

		assertEquals(20, board.caculcatePoint(Color.BLACK), 0.01);
		assertEquals(20.5, board.caculcatePoint(Color.WHITE), 0.01);

	}

	private void addPiece(String position, Piece piece) {
		board.move(position, piece);
	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}

}
