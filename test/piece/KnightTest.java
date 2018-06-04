package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import chess.Position;
import piece.Piece.Type;

public class KnightTest {
	@Test
	public void create_knight() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Knight.createWhiteKnight(position), Knight.createBlackKnight(position), Type.KNIGHT);
	}

	private void verifyPiece(Knight whitePiece, Knight blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
