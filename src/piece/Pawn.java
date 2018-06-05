package piece;

import java.util.List;

public class Pawn extends Piece {

	private Pawn(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Pawn create(Color color, Position position) {
		return new Pawn(color, Type.PAWN, position);
	}

	public static Pawn createBlack(Position position) {
		return new Pawn(Color.BLACK, Type.PAWN, position);
	}

	public static Pawn createWhite(Position position) {
		return new Pawn(Color.WHITE, Type.PAWN, position);
	}

	@Override
	public boolean verifyMovePosition(Piece piece) {
		Position position = this.getPosition();
		List<Position> positions = position.getPawnMovementAble(this.getColor());
		if (positions.contains(piece.getPosition())) {
			return true;
		}
		return false;
	}
}
