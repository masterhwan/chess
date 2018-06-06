package piece;

import Exception.InvalidMovePositionException;

public class Rook extends Piece {

	private Rook(Color color, Position position) {
		super(color, Type.ROOK, position, Direction.linearDirection());
	}

	public static Rook createBlack(Position position) {
		return new Rook(Color.BLACK, position);
	}

	public static Rook createWhite(Position position) {
		return new Rook(Color.WHITE, position);
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
