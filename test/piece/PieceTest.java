package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PieceTest {

	@Test
	public void isWhiteAndBlack() throws Exception {
		Position position = new Position(1, 1);
		Piece whitePawn = Pawn.createWhite(position);
		assertTrue(whitePawn.isWhite());
		assertEquals('p', whitePawn.getRepresentation());

		Piece blackPawn = Pawn.createBlack(position);
		assertTrue(blackPawn.isBlack());
		assertEquals('P', blackPawn.getRepresentation());
	}
}
