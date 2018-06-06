package piece;

import Exception.InvalidMovePositionException;

public class Queen extends Piece {

	private Queen(Color color, Position position) {
		super(color, Type.QUEEN, position, Direction.everyDirection());
	}

	public static Queen createWhite(Position position) {
		return new Queen(Color.WHITE, position);
	}

	public static Queen createBlack(Position position) {
		return new Queen(Color.BLACK, position);
	}

	@Override
	public Direction verifyMovePosition(Piece target) {
		Direction direction = getPosition().direction(target.getPosition());
		if (!super.getDirections().contains(direction)) {
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
}
