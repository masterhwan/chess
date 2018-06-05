package piece;

import static org.junit.Assert.*;

import org.junit.Test;

import piece.Piece.Type;

public class KnightTest {
	@Test
	public void create_knight() throws Exception {
		Position position = new Position(1, 1);
		verifyPiece(Knight.createWhite(position), Knight.createBlack(position), Type.KNIGHT);
	}

	private void verifyPiece(Knight whitePiece, Knight blackPiece, Type type) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());

		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
	}

	@Test
	public void verifyMovePosition() throws Exception {
        Knight knight = Knight.createWhite(new Position("d4"));
        knight.verifyMovePosition(Blank.create(new Position("b3")));
        knight.verifyMovePosition(Blank.create(new Position("b5")));
        knight.verifyMovePosition(Blank.create(new Position("c2")));
        knight.verifyMovePosition(Blank.create(new Position("c6")));
        knight.verifyMovePosition(Blank.create(new Position("e2")));
        knight.verifyMovePosition(Blank.create(new Position("e6")));
        knight.verifyMovePosition(Blank.create(new Position("f3")));
        knight.verifyMovePosition(Blank.create(new Position("f5")));
	}
}
