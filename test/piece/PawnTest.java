package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import piece.Piece.Type;

public class PawnTest {
	@Test
	public void create_pawn() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Pawn.createWhite(position), Pawn.createBlack(position), Type.PAWN);
	}

	private void verifyPiece(Pawn whitePiece, Pawn blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test
	public void verifyMovePosition() throws Exception {
		Pawn pawn = Pawn.createWhite(new Position("e2"));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("e3"))));
		// assertTrue(pawn.verifyMovePosition(Blank.create(new Position("e4"))));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("d3"))));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("f3"))));

		pawn = Pawn.createBlack(new Position("e7"));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("e6"))));
		// assertTrue(pawn.verifyMovePosition(Blank.create(new Position("e5"))));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("d6"))));
		assertTrue(pawn.verifyMovePosition(Blank.create(new Position("f6"))));
	}
}
