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
}
