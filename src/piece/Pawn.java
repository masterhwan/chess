package piece;

import java.util.Arrays;
import java.util.List;

import Exception.InvalidMovePositionException;
import piece.Position.Degree;

public class Pawn extends Piece {

	private int WHITE_PAWN_START_POSITION = 2;
	private int BLACK_PAWN_START_POSITION = 7;

	private Pawn(Color color, Position position, List<Direction> directions) {
		super(color, Type.PAWN, position, directions);
	}

	private Pawn(Color color, Position position) {
		super(color, Type.PAWN, position, Arrays.asList());
	}

	public static Pawn create(Color color, Position position) {
		return new Pawn(color, position);
	}

	public static Pawn createBlack(Position position) {
		return new Pawn(Color.BLACK, position, Direction.blackPawnDirection());
	}

	public static Pawn createWhite(Position position) {
		return new Pawn(Color.WHITE, position, Direction.whitePawnDirection());
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
		Degree degree = getPosition().degree(target.getPosition());
		if (degree.isOverOneYDegree() && !isStartingPosition()) {
			throw new InvalidMovePositionException("1");
		}

		if (isStartingPosition() && !degree.isUnderThreeYDegree()) {
			throw new InvalidMovePositionException("1");
		}
		return direction;
	}

	private boolean isAlliance(Piece target) {
		return getColor() == target.getColor();
	}

	public boolean isStartingPosition() {
		return getPosition().getY() == getStartPosition();
	}

	private int getStartPosition() {
		if (super.isWhite()) {
			return WHITE_PAWN_START_POSITION;
		}
		return BLACK_PAWN_START_POSITION;
	}
}
