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
			throw new InvalidMovePositionException("같은 편의 위치로는 움직일 수 없음");
		}

		if (!getDirections().contains(direction)) {
			throw new InvalidMovePositionException(target + "방향으로 움직일수 없음");
		}

		Degree degree = degree(target);
		if (degree.isOverOneXDegree() || degree.isOverOneYDegree()) {
			throw new InvalidMovePositionException(target + "방향으로 움직일수 없음");
		}

		return direction;
	}

	private boolean isAlliance(Piece target) {
		return getColor() == target.getColor();
	}

	@Override
	public void move(Piece target) {
		verifyMovePosition(target);
		setPosition(target.getPosition());
	}
}
