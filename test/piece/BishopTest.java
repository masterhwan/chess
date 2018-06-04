package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Position;
import piece.Piece.Type;

public class BishopTest {
	@Test
	public void create_bishop() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Bishop.createWhiteBishop(position), Bishop.createBlackBishop(position), Type.BISHOP);
	}

	private void verifyPiece(Bishop whitePiece, Bishop blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
