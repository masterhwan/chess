package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {

	@Test
	public void createBlackPawn() {
		BlackPawn blackPawn = new BlackPawn();
		assertEquals("black", blackPawn.getColar());
	}
}
