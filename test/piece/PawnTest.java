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
		verifyPawn(Pawn.WHITE_COLOR);
		verifyPawn(Pawn.BLACK_COLOR);
	}

	private void verifyPawn(String color) {
		Pawn pawn = new Pawn(color);
		assertEquals(color, pawn.getColor());
	}

	@Test
	public void create_기본생성자() throws Exception {
		Pawn pawn = new Pawn();
		assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
	}
}
