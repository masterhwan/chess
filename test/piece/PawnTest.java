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
		String white = "white";
		String black = "black";
		verifyPawn(white);
		verifyPawn(black);
	}

	private void verifyPawn(String color) {
		Pawn pawn = new Pawn(color);
		assertEquals(color, pawn.getColor());
	}
}
