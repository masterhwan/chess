package piece;

public class Piece {
	public enum Color {
		BLACK, WHITE, NOCOLOR;
	}

	public enum Type {
		PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

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

	private static Piece createWhite(Type type) {
		return new Piece(Color.WHITE, type);
	}

	public static Piece createWhitePawn() {
		return createWhite(Type.PAWN);
	}

	public static Piece createWhiteRook() {
		return createWhite(Type.ROOK);
	}

	public static Piece createWhiteKnight() {
		return createWhite(Type.KNIGHT);
	}

	public static Piece createWhiteBishop() {
		return createWhite(Type.BISHOP);
	}

	public static Piece createWhiteQueen() {
		return createWhite(Type.QUEEN);
	}

	public static Piece createWhiteKing() {
		return createWhite(Type.KING);
	}

	private static Piece createBlack(Type type) {
		return new Piece(Color.BLACK, type);
	}

	public static Piece createBlackPawn() {
		return createBlack(Type.PAWN);
	}

	public static Piece createBlackRook() {
		return createBlack(Type.ROOK);
	}

	public static Piece createBlackKnight() {
		return createBlack(Type.KNIGHT);
	}

	public static Piece createBlackBishop() {
		return createBlack(Type.BISHOP);
	}

	public static Piece createBlackQueen() {
		return createBlack(Type.QUEEN);
	}

	public static Piece createBlackKing() {
		return createBlack(Type.KING);
	}

	public static Piece createBlank() {
		return new Piece(Color.NOCOLOR, Type.NO_PIECE);
	}

	public boolean isBlack() {
		return color.equals(Color.BLACK);
	}

	public boolean isWhite() {
		return color.equals(Color.WHITE);
	}

	public Type getType() {
		return type;
	}

}
