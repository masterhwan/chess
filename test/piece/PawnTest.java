package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess.Position;
import piece.Piece.Type;

public class PawnTest {
	@Test
	public void create_pawn() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Pawn.createWhitePawn(position), Pawn.createBlackPawn(position), Type.PAWN);
	}

	private void verifyPiece(Pawn whitePiece, Pawn blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}
}
