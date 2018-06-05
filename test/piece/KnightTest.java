package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import piece.Piece.Type;

public class KnightTest {
	@Test
	public void create_knight() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Knight.createWhite(position), Knight.createBlack(position), Type.KNIGHT);
	}

	private void verifyPiece(Knight whitePiece, Knight blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
