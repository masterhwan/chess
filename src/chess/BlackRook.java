package chess;

public class BlackRook {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackRook() {
		color = "black";
		name = "rook";
		display = "R";
		score = 2.0;
		move = false;
	}

	public double getScore() {
		return score;
	}
}
