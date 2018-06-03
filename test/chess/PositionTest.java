package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {

	@Test
	public void create_position() throws Exception {
		Position position = new Position("a1");
		assertEquals(1, position.getX());
		assertEquals(1, position.getY());
		
		assertEquals(0, position.getXIndex());
		assertEquals(0, position.getYIndex());
	}
}
