package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest {
	@Test
	public void getBlackRookScore() throws Exception {
		BlackRook br = new BlackRook();
		assertEquals((double) 2.0, br.getScore(), 0);
	}

	@Test
	public void getWhiteRookScore() throws Exception {
		WhiteRook wr = new WhiteRook();
		assertEquals(2.0, wr.getScore(), 0);
	}
}
