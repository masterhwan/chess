package piece;

import Exception.InvalidMovePositionException;

public class Knight extends Piece {

	private Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position, Direction.knightDirection());
	}

	public static Knight createWhite(Position position) {
		return new Knight(Color.WHITE, position);
	}

	public static Knight createBlack(Position position) {
		return new Knight(Color.BLACK, position);
	}

	@Override
	public Direction verifyMovePosition(Piece target) {
		Direction direction = getPosition().direction(target.getPosition());
		if (isAlliance(target)) {
			throw new InvalidMovePositionException("1");
		}

		if (!getDirections().contains(direction)) {
			throw new InvalidMovePositionException("1");
		}
		return direction;
	}

	private boolean isAlliance(Piece target) {
		return getColor() == target.getColor();
	}

}
