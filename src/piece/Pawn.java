package piece;

public class Pawn {
	public static final String WHITE_COLOR = "white";
	public static final String BLACK_COLOR = "black";
	public static final String WHITE_REPRESENTATION = "p";
	public static final String BLACK_REPRESENTATION = "P";

	private String color;
	private String representation;

	public Pawn(String color) {
		this.color = color;
	}

	public Pawn() {
		color = WHITE_COLOR;
		representation = WHITE_REPRESENTATION;
	}

	public Pawn(String color, String representation) {
		this.color = color;
		this.representation = representation;
	}

	public Object getColor() {
		return color;
	}

	public String getRepresentation() {
		return representation;
	}

}
