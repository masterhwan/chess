package piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import Exception.InvalidMovePositionException;
import piece.Piece.Type;

public class BlankTest {
	@Test
	public void create_Blank() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Blank.create(position), Type.NO_PIECE);
	}

	private void verifyPiece(Blank blank, Type type) {
		assertFalse(blank.isWhite());
		assertEquals(type, blank.getType());
	}

	@Test(expected = InvalidMovePositionException.class)
	public void verifyMovePosition() throws Exception {
		Blank blank = Blank.create(new Position("b3"));
		blank.verifyMovePosition(Blank.create(new Position("b4")));
	}
}
