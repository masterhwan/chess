package piece;

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
	public boolean verifyMovePosition() {
		// TODO Auto-generated method stub
		return false;
	}

}
