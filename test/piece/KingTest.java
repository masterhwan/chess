package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {
	@Test
	public void getBlackKingColor() throws Exception {
		BlackKing bk = new BlackKing();
		assertEquals("black", bk.getColor());
	}

	@Test
	public void getWhiteKingScore() throws Exception {
		WhiteKing wk = new WhiteKing();
		assertEquals((double) 0, wk.getScore(), 0);
	}
}
