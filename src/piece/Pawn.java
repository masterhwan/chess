package piece;

public class Pawn {
	final public static String WHITE_COLOR = "white";
	final public static String BLACK_COLOR = "black";
	String color;

	public Pawn(String color) {
		this.color = color;
	}

	public Pawn() {
		color = "white";
	}

	public Object getColor() {
		return color;
	}

}
