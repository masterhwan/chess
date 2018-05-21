package chess;

public class BlackKing {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackKing() {
		color = "black";
		name = "king";
		display = "K";
		score = 0;
		move = false;
	}

	public String getColor() {
		return color;
	}

}
