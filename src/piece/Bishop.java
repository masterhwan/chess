package piece;

import Exception.InvalidMovePositionException;

public class Bishop extends Piece {

	private Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position, Direction.diagonalDirection());
	}

	public static Bishop createWhite(Position position) {
		return new Bishop(Color.WHITE, position);
	}

	public static Bishop createBlack(Position position) {
		return new Bishop(Color.BLACK, position);
	}

	@Override
	public Direction verifyMovePosition(Piece target) {
		Direction direction = getPosition().direction(target.getPosition());
		if (!getDirections().contains(direction)) {
			throw new InvalidMovePositionException(target + "방향으로 움직일수 없음");
		}

		if (isAlliance(target)) {
			throw new InvalidMovePositionException("같은 편의 위치로는 움직일 수 없음");
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
