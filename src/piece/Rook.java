package piece;

import java.util.List;

public class Rook extends Piece {

	private Rook(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Rook createBlack(Position position) {
		return new Rook(Color.BLACK, Type.ROOK, position);
	}

	public static Rook createWhite(Position position) {
		return new Rook(Color.WHITE, Type.ROOK, position);
	}

	@Override
	public boolean verifyMovePosition(Piece piece) {
		Position position = this.getPosition();
		List<Position> positions = position.getRookMovementAble();
		if (positions.contains(piece.getPosition())) {
			return true;
		}
		return false;	}
}
