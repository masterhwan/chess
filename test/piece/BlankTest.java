package piece;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
