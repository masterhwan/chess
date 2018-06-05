package piece;

import java.util.List;

public class Knight extends Piece {

	private Knight(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Knight createWhite(Position position) {
		return new Knight(Color.WHITE, Type.KNIGHT, position);
	}

	public static Knight createBlack(Position position) {
		return new Knight(Color.BLACK, Type.KNIGHT, position);
	}

	@Override
	public boolean verifyMovePosition(Piece piece) {
		Position position = this.getPosition();
		List<Position> positions = position.getKnightMovementAble();
		if (positions.contains(piece.getPosition())) {
			return true;
		}
		return false;
	}
}
