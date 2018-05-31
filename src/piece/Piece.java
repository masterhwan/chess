package piece;

public class Piece {
	public static final String WHITE_COLOR = "white";
	public static final String BLACK_COLOR = "black";
	public static final String BLACK_PAWN_REPRESENTATION = "P";
	public static final String WHITE_PAWN_REPRESENTATION = "p";
	public static final String WHITE_ROOK_REPRESENTATION = "r";
	public static final String BLACK_ROOK_REPRESENTATION = "R";
	public static final String BLACK_KNIGHT_REPRESENTATION = "N";
	public static final String WHITE_KNIGHT_REPRESENTATION = "n";
	public static final String BLACK_BISHOP_REPRESENTATION = "B";
	public static final String WHITE_BISHOP_REPRESENTATION = "b";
	public static final String WHITE_QUEEN_REPRESENTATION = "q";
	public static final String WHITE_KING_REPRESENTATION = "k";
	public static final String BLACK_QUEEN_REPRESENTATION = "Q";
	public static final String BLACK_KING_REPRESENTATION = "K";

	private String color;
	private String representation;

	private Piece(String color) {
		this.color = color;
	}

	private Piece() {
		color = WHITE_COLOR;
		representation = WHITE_PAWN_REPRESENTATION;
	}

	private Piece(String color, String representation) {
		this.color = color;
		this.representation = representation;
	}

	public Object getColor() {
		return color;
	}

	public String getRepresentation() {
		return representation;
	}

	public static Piece createWhitePawn() {
		return new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
	}

	public static Piece createBlackPawn() {
		return new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
	}

	public static Piece createWhiteRook() {
		return new Piece(WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
	}

	public static Piece createBlackRook() {
		return new Piece(BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
	}

	public static Piece createWhiteKnight() {
		return new Piece(WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
	}

	public static Piece createWhiteBishop() {
		return new Piece(WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
	}

	public static Piece createWhiteQueen() {
		return new Piece(WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
	}

	public static Piece createWhiteKing() {
		return new Piece(WHITE_COLOR, WHITE_KING_REPRESENTATION);
	}

	public static Piece createBlackKight() {
		return new Piece(BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
	}

	public static Piece createBlackBishop() {
		return new Piece(BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
	}

	public static Piece createBlackQueen() {
		return new Piece(BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
	}

	public static Piece createBlackKing() {
		return new Piece(BLACK_COLOR, BLACK_KING_REPRESENTATION);
	}

}
