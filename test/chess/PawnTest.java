package chess;

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
}
