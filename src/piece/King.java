package piece;

import java.util.List;

import Exception.InvalidMovePositionException;
import piece.Position.Degree;

public class King extends Piece {
	private King(Color color, Type type, Position position, List<Direction> directions) {
		super(color, type, position, directions);
	}

	public static King createWhite(Position position) {
		return new King(Color.WHITE, Type.KING, position, Direction.everyDirection());
	}

	public static King createBlack(Position position) {
		return new King(Color.BLACK, Type.KING, position, Direction.everyDirection());
	}

	@Override
	public Direction verifyMovePosition(Piece target) {
		Direction direction = getPosition().direction(target.getPosition());
		if (isAlliance(target)) {
			throw new InvalidMovePositionException("error");
		}

		if (!getDirections().contains(direction)) {
			throw new InvalidMovePositionException("error");
		}

		Degree degree = degree(target);
		if (degree.isOverOneXDegree() || degree.isOverOneYDegree()) {
			throw new InvalidMovePositionException(target + " 위치는 이동할 수 없는 위치입니다.");
		}

		return direction;
	}

	private boolean isAlliance(Piece target) {
		return getColor() == target.getColor();
	}
}
