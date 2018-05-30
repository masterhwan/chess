package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {
	@Test
	public void getBlackBishopName() throws Exception {
		BlackBishop bb = new BlackBishop();
		assertEquals("bishop", bb.getBishopName());
	}

	@Test
	public void getWhiteBishopName() throws Exception {
		WhiteBishop wb = new WhiteBishop();
		assertEquals("bishop", wb.getBishopName());
	}
}
