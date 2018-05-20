package chess;

public class WhitePawn {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhitePawn() {
		color = "white";
		name = "pawn";
		display = "p";
		score = 1;
		move = true;
	}

	public String getColor() {
		return color;
	}

}
