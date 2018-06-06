package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Exception.InvalidMovePositionException;
import piece.Piece.Type;

public class RookTest {
	@Test
	public void create_rook() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Rook.createWhite(position), Rook.createBlack(position), Type.ROOK);
	}

	private void verifyPiece(Rook whitePiece, Rook blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

    @Test (expected = InvalidMovePositionException.class)
    public void verifyMovePosition_invalid() throws Exception {
        Rook rook= Rook.createWhite(new Position("d1"));
        rook.verifyMovePosition(Pawn.createWhite(new Position("e6")));
    }
    
    @Test
    public void verifyMovePosition() throws Exception {
        Rook rook= Rook.createWhite(new Position("d5"));
        rook.verifyMovePosition(Blank.create(new Position("d8")));
        rook.verifyMovePosition(Blank.create(new Position("d1")));
        rook.verifyMovePosition(Blank.create(new Position("a5")));
        rook.verifyMovePosition(Blank.create(new Position("h5")));
	}
}
