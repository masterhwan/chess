package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {

	@Test
	public void createBlackPawn() {
		BlackPawn blackPawn = new BlackPawn();
		assertEquals("black", blackPawn.getColar());
	}

	@Test
	public void createWhitePawn() {
		WhitePawn whitePawn = new WhitePawn();
		assertEquals("white", whitePawn.getColor());
	}

	@Test
	public void create() {
		verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
		verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
	}

	private void verifyPawn(String color, String representation) {
		Pawn pawn = new Pawn(color, representation);
		assertEquals(color, pawn.getColor());
		assertEquals(representation, pawn.getRepresentation());
	}

	@Test
	public void create_기본생성자() throws Exception {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
		assertEquals(Pawn.WHITE_REPRESENTATION, pawn.getRepresentation());
	}
}
