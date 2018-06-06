package piece;

import java.util.Arrays;
import java.util.List;

import Exception.InvalidMovePositionException;

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

	public static Direction valueOf(int x, int y) throws InvalidMovePositionException {
		if (x == 0 && y == 0) {
			throw new InvalidMovePositionException("유효하지 않은 위치");
		}

		Direction[] directions = values();
		for (Direction index : directions) {
			if (x == index.getX() && y == index.getY()) {
				return index;
			}
		}

		if (x == 0) {
			return getNorthOrSouth(y);
		}

		if (y == 0) {
			return getWestOrEast(x);
		}

		int remainder = x % y;

		if (remainder != 0) {
			throw new InvalidMovePositionException("유효하지 않은 위치입니다.");
		}

		int quotient = x / y;

		if (quotient == 1) {
			return getNorthEastOrSouthWest(x);
		}

		if (quotient == -1) {
			return getNorthWestOrSouthEast(x);
		}
		throw new InvalidMovePositionException("유효하지 않은 위치");
	}

	private static Direction getNorthEastOrSouthWest(int x) {
		if (x > 0) {
			return NORTH_EAST;
		}
		return SOUTH_WEST;
	}

	private static Direction getNorthWestOrSouthEast(int x) {
		if (x < 0) {
			return NORTH_WEST;
		}
		return SOUTH_EAST;
	}

	private static Direction getWestOrEast(int x) {
		if (x > 0) {
			return EAST;
		}
		return WEST;
	}

	private static Direction getNorthOrSouth(int y) {
		if (y > 0) {
			return NORTH;
		}
		return SOUTH;
	}
}
