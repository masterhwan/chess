package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import Exception.InvalidMovePositionException;
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

	@Test
	public void verifyMovePosition() throws Exception {
		Queen queen = Queen.createWhite(new Position("d4"));
		queen.verifyMovePosition(Blank.create(new Position("a1")));
		queen.verifyMovePosition(Blank.create(new Position("a7")));
		queen.verifyMovePosition(Blank.create(new Position("h4")));
		queen.verifyMovePosition(Blank.create(new Position("h8")));
		queen.verifyMovePosition(Blank.create(new Position("d1")));
		queen.verifyMovePosition(Blank.create(new Position("d8")));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition_invalid() throws Exception {
		Queen queen = Queen.createWhite(new Position("d4"));
		queen.verifyMovePosition(Pawn.createWhite(new Position("b3")));
	}

}
