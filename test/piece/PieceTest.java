package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chess.Position;

public class PieceTest {

	@Test
	public void isWhiteAndBlack() throws Exception {
		Position position = new Position(1, 1);
		Piece whitePawn = Pawn.createWhitePawn(position);
		assertTrue(whitePawn.isWhite());
		assertEquals('p', whitePawn.getRepresentation());

		Piece blackPawn = Pawn.createBlackPawn(position);
		assertTrue(blackPawn.isBlack());
		assertEquals('P', blackPawn.getRepresentation());
	}
}
