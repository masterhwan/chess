package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import piece.Piece.Type;

public class QueenTest {
	@Test
	public void create_queen() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Queen.createWhite(position), Queen.createBlack(position), Type.QUEEN);
	}

	private void verifyPiece(Queen whitePiece, Queen blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test
	public void verifyMovePosition() throws Exception {
		Queen queen = Queen.createWhite(new Position("d4"));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("a1"))));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("a7"))));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("h4"))));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("h8"))));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("d1"))));
		assertTrue(queen.verifyMovePosition(Blank.create(new Position("d8"))));
	}
}
