package piece;

import java.util.List;

public class Bishop extends Piece {

	private Bishop(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Bishop createWhite(Position position) {
		return new Bishop(Color.WHITE, Type.BISHOP, position);
	}

	public static Bishop createBlack(Position position) {
		return new Bishop(Color.BLACK, Type.BISHOP, position);
	}

	@Override
	public boolean verifyMovePosition(Piece piece) {
		Position position = this.getPosition();
		List<Position> positions = position.getBishopMovementAble();
		if (positions.contains(piece.getPosition())) {
			return true;
		}
		return false;
	}
}
