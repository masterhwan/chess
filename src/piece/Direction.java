package piece;

import java.util.Arrays;
import java.util.List;

public enum Direction {
	NORTH(0, 1), NORTH_EAST(1, 1), EAST(1, 0), SOUTH_EAST(1, -1), SOUTH(0, -1), SOUTH_WEST(-1, -1), WEST(-1,
			0), NORTH_WEST(-1,
					1), NNW(-1, 2), NNE(1, 2), EEN(2, 1), EES(2, -1), SSE(1, -2), SSW(-1, -2), WWS(-2, -1), WWN(-2, 1);

	private int x;
	private int y;

	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static List<Direction> linearDirection() {
		return Arrays.asList(NORTH, EAST, SOUTH, WEST);
	}

	public static List<Direction> diagonalDirection() {
		return Arrays.asList(NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
	}

	public static List<Direction> everyDirection() {
		return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
	}

	public static List<Direction> knightDirection() {
		return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
	}

	public static List<Direction> whitePawnDirection() {
		return Arrays.asList(NORTH, NORTH_EAST, NORTH_WEST);
	}

	public static List<Direction> blackPawnDirection() {
		return Arrays.asList(SOUTH, SOUTH_EAST, SOUTH_WEST);
	}

}
