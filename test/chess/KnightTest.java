package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {
	@Test
	public void showBlackKnightDisplay() throws Exception {
		BlackKnight bk = new BlackKnight();
		assertEquals("N", bk.getDisplay());
	}

	@Test
	public void showWhiteKnightDisplay() throws Exception {
		WhiteKnight wk = new WhiteKnight();
		assertEquals("n", wk.getDisplay());
	}
}
