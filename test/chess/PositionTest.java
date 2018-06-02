package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {

	@Test
	public void create_position() throws Exception {
		Position position = new Position("a1");
		assertEquals(0, position.getXpos());
		assertEquals(0, position.getYpos());
	}
}
