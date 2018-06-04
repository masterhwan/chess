package piece;

import chess.Position;

public class Rook extends Piece {

	private Rook(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Rook createBlackRook(Position position) {
		return new Rook(Color.BLACK, Type.ROOK, position);
	}

	public static Rook createWhiteRook(Position position) {
		return new Rook(Color.WHITE, Type.ROOK, position);
	}

}
