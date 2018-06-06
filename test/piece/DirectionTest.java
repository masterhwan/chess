package piece;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Exception.InvalidMovePositionException;

public class DirectionTest {

	@Test
	public void north_south() throws Exception {
		assertEquals(Direction.NORTH, Direction.valueOf(0, 1));
		assertEquals(Direction.NORTH, Direction.valueOf(0, 5));
		assertEquals(Direction.NORTH, Direction.valueOf(0, 9));

		assertEquals(Direction.SOUTH, Direction.valueOf(0, -1));
		assertEquals(Direction.SOUTH, Direction.valueOf(0, -4));
		assertEquals(Direction.SOUTH, Direction.valueOf(0, -9));
	}

	@Test
	public void east_west() throws Exception {
		assertEquals(Direction.EAST, Direction.valueOf(1, 0));
		assertEquals(Direction.EAST, Direction.valueOf(5, 0));

		assertEquals(Direction.WEST, Direction.valueOf(-1, 0));
		assertEquals(Direction.WEST, Direction.valueOf(-5, 0));
	}

	@Test
	public void northeast_southwest() throws Exception {
		assertEquals(Direction.NORTH_EAST, Direction.valueOf(1, 1));
		assertEquals(Direction.NORTH_EAST, Direction.valueOf(4, 4));

		assertEquals(Direction.SOUTH_WEST, Direction.valueOf(-1, -1));
		assertEquals(Direction.SOUTH_WEST, Direction.valueOf(-4, -4));
	}

	@Test
	public void northwest_southeast() throws Exception {
		assertEquals(Direction.SOUTH_EAST, Direction.valueOf(1, -1));
		assertEquals(Direction.SOUTH_EAST, Direction.valueOf(4, -4));

		assertEquals(Direction.NORTH_WEST, Direction.valueOf(-1, 1));
		assertEquals(Direction.NORTH_WEST, Direction.valueOf(-4, 4));
	}

	@Test
	public void valueOf() {
		assertEquals(Direction.NORTH_EAST, Direction.valueOf(1, 1));
		assertEquals(Direction.NORTH, Direction.valueOf(0, 1));
		assertEquals(Direction.SSE, Direction.valueOf(1, -2));
	}

	@Test(expected = InvalidMovePositionException.class)
	public void valueOf_invalid() throws Exception {
		Direction.valueOf(2, 3);
	}
}
