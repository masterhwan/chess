package piece;

public class Queen extends Piece {

	private Queen(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Queen createWhite(Position position) {
		return new Queen(Color.WHITE, Type.QUEEN, position);
	}

	public static Queen createBlack(Position position) {
		return new Queen(Color.BLACK, Type.QUEEN, position);
	}

	@Override
	public boolean verifyMovePosition() {
		// TODO Auto-generated method stub
		return false;
	}

}
