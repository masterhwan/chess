package piece;

public class Piece {
	public enum Color {
		BLACK, WHITE, NOCOLOR;
	}

	public enum Type {
		PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE(' ');

		private char representation;

		Type(char representation) {
			this.representation = representation;
		}

		public char getWhiteRepresentation() {
			return representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(representation);
		}
	}

	private Color color;
	private char representaion;
	private Type type;

	private Piece(Color color) {
		this.color = color;
	}

	private Piece() {
		color = Color.WHITE;
		representaion = Type.PAWN.getWhiteRepresentation();
	}

	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		if (color.equals(Color.WHITE)) {
			this.representaion = type.getWhiteRepresentation();
			return;
		}
		this.representaion = type.getBlackRepresentation();
	}

	public Object getColor() {
		return color;
	}

	public char getRepresentation() {
		return representaion;
	}

	public static Piece createWhitePawn() {
		return new Piece(Color.WHITE, Type.PAWN);
	}

	public static Piece createBlackPawn() {
		return new Piece(Color.BLACK, Type.PAWN);
	}

	public static Piece createWhiteRook() {
		return new Piece(Color.WHITE, Type.ROOK);
	}

	public static Piece createBlackRook() {
		return new Piece(Color.BLACK, Type.ROOK);
	}

	public static Piece createWhiteKnight() {
		return new Piece(Color.WHITE, Type.KNIGHT);
	}

	public static Piece createWhiteBishop() {
		return new Piece(Color.WHITE, Type.BISHOP);
	}

	public static Piece createWhiteQueen() {
		return new Piece(Color.WHITE, Type.QUEEN);
	}

	public static Piece createWhiteKing() {
		return new Piece(Color.WHITE, Type.KING);
	}

	public static Piece createBlackKnight() {
		return new Piece(Color.BLACK, Type.KNIGHT);
	}

	public static Piece createBlackBishop() {
		return new Piece(Color.BLACK, Type.BISHOP);
	}

	public static Piece createBlackQueen() {
		return new Piece(Color.BLACK, Type.QUEEN);
	}

	public static Piece createBlackKing() {
		return new Piece(Color.BLACK, Type.KING);
	}

	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}

	public boolean isWhite() {
		return color.equals(Color.WHITE);
	}

	public static Piece createBlank() {
		return new Piece(Color.NOCOLOR, Type.NO_PIECE);
	}

	public Type getType() {
		return type;
	}

}
