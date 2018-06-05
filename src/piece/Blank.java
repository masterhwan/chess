package piece;

public class Blank extends Piece {

	private Blank(Color color, Type type, Position position) {
		super(color, type, position);
	}

	public static Blank create(Position position) {
		return new Blank(Color.NOCOLOR, Type.NO_PIECE, position);
	}

	@Override
	public boolean verifyMovePosition() {
		// TODO Auto-generated method stub
		return false;
	}

}
