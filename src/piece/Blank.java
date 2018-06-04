package piece;

import chess.Position;

public class Blank extends Piece {

	private Blank(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Blank createBlank(Position position) {
		return new Blank(Color.NOCOLOR, Type.NO_PIECE, position);
	}

}
