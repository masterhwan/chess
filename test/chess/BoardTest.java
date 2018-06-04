package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
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

	}
}
