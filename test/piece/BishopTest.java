package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.InvalidMovePositionException;
import piece.Piece.Type;

public class BishopTest {
	@Test
	public void create_bishop() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Bishop.createWhite(position), Bishop.createBlack(position), Type.BISHOP);

	}

	private void verifyPiece(Bishop whitePiece, Bishop blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_invalid() throws Exception {
		Bishop bishop = Bishop.createWhite(new Position("d5"));
		Pawn pawn = Pawn.createWhite(new Position("f5"));
		bishop.verifyMovePosition(pawn);
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_sameTeam() throws Exception {
		Bishop bishop = Bishop.createWhite(new Position("d5"));
		bishop.verifyMovePosition(Pawn.createWhite(new Position("g8")));
	}

	@Test
	public void verifyMovePosition_otherTeam() throws Exception {
		Bishop bishop = Bishop.createWhite(new Position("d5"));
		bishop.verifyMovePosition(Pawn.createBlack(new Position("g8")));
	}

	@Test
	public void verifyMovePosition() throws Exception {
		Bishop bishop = Bishop.createWhite(new Position("d5"));
		bishop.verifyMovePosition(Blank.create(new Position("g8")));
		bishop.verifyMovePosition(Blank.create(new Position("a2")));
		bishop.verifyMovePosition(Blank.create(new Position("h1")));
		bishop.verifyMovePosition(Blank.create(new Position("a8")));
	}
}
