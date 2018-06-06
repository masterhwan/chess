package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.InvalidMovePositionException;
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

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_inValid() throws Exception {
		King king = King.createWhite(new Position("d1"));
		Pawn pawn = Pawn.createBlack(new Position("d3"));
		king.verifyMovePosition(pawn);
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_sameTeam() throws Exception {
		King king = King.createWhite(new Position("d1"));
		Pawn pawn = Pawn.createWhite(new Position("d2"));
		king.verifyMovePosition(pawn);
	}

	@Test
	public void verifyMovePosition_otherTeam() throws Exception {
		King king = King.createWhite(new Position("d1"));
		Pawn pawn = Pawn.createBlack(new Position("e2"));
		king.verifyMovePosition(pawn);
	}

	@Test
	public void verifyMovePosition() throws Exception {
		King king = King.createWhite(new Position("f5"));
		king.verifyMovePosition(Blank.create(new Position("f6")));
		king.verifyMovePosition(Blank.create(new Position("e5")));
	}
}
