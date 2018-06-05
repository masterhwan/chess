package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import piece.Piece.Type;

public class KingTest {
	@Test
	public void create_King() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(King.createWhite(position), King.createBlack(position), Type.KING);
	}

	private void verifyPiece(King whitePiece, King blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
