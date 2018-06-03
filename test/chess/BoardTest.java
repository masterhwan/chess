package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Color;
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
		board.initialize();
		assertEquals(64, board.pieceCount());
		assertEquals(appendNewLine("RNBQKBNR") + appendNewLine("PPPPPPPP") + blankRank + blankRank + blankRank
				+ blankRank + appendNewLine("pppppppp") + appendNewLine("rnbqkbnr"), board.showBoard());
	}

	@Test
	public void countPieceByColorAndType() throws Exception {
		board.initialize();
		assertEquals(8, board.countPieceByColorAndType(Color.WHITE, Type.PAWN));
		assertEquals(2, board.countPieceByColorAndType(Color.BLACK, Type.KNIGHT));
		assertEquals(1, board.countPieceByColorAndType(Color.BLACK, Type.KING));
	}

	@Test
	public void find_piece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlackRook(new Position("a8")), board.findPiece("a8"));
		assertEquals(Piece.createBlackRook(new Position("h8")), board.findPiece("h8"));
		assertEquals(Piece.createWhiteRook(new Position("a1")), board.findPiece("a1"));
		assertEquals(Piece.createWhiteRook(new Position("h1")), board.findPiece("h1"));
		assertEquals(Piece.createBlank(new Position("c4")), board.findPiece("c4"));
		System.out.println(board.showBoard());
	}

	@Test
	public void move() throws Exception {
		board.initialize();
		String sourcePosition = "b2";
		String targetPosition = "b3";

		board.move(sourcePosition, targetPosition);

		assertEquals(Piece.createBlank(new Position(sourcePosition)), board.findPiece(sourcePosition));
		assertEquals(Piece.createWhitePawn(new Position(targetPosition)), board.findPiece(targetPosition));

		sourcePosition = "d1";
		targetPosition = "h7";

		board.move(sourcePosition, targetPosition);

		System.out.println(board.showBoard());
	}

	@Test
	public void caculcatePoint() throws Exception {
		board.emptyInitialize();

		addPiece(Piece.createBlackPawn(new Position("b6")));
		addPiece(Piece.createBlackQueen(new Position("e6")));
		addPiece(Piece.createBlackKing(new Position("b8")));
		addPiece(Piece.createBlackRook(new Position("c8")));

		addPiece(Piece.createWhitePawn(new Position("f2")));
		addPiece(Piece.createWhitePawn(new Position("g2")));
		addPiece(Piece.createWhiteRook(new Position("e1")));
		addPiece(Piece.createWhiteKing(new Position("f1")));

		System.out.println(board.showBoard());

		assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
		assertEquals(7.0, board.caculcatePoint(Color.WHITE), 0.01);

	}

	// @Test
	// public void caculcatePoint_pawn() throws Exception {
	// board.emptyInitialize();
	//
	// addPiece(Piece.createBlackPawn(new Position("b1")));
	// addPiece(Piece.createBlackPawn(new Position("b2")));
	// addPiece(Piece.createBlackPawn(new Position("b3")));
	// addPiece(Piece.createBlackPawn(new Position("b4")));
	// addPiece(Piece.createBlackPawn(new Position("b5")));
	// addPiece(Piece.createBlackPawn(new Position("b6")));
	// addPiece(Piece.createBlackPawn(new Position("b7")));
	// addPiece(Piece.createBlackPawn(new Position("b8")));
	//
	// assertEquals(4, board.caculcatePoint(Color.BLACK), 0.01);
	// }

	private void addPiece(Piece piece) {
		board.move(piece.getPosition(), piece);
	}

	private String appendNewLine(String string) {
		StringBuffer bf = new StringBuffer();
		bf.append(string);
		return bf.toString() + returnLine;
	}

}
