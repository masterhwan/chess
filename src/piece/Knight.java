package piece;

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
	public boolean verifyMovePosition() {
		// TODO Auto-generated method stub
		return false;
	}

}
