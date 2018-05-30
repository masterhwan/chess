package piece;

public class WhiteRook {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhiteRook() {
		color = "white";
		name = "rook";
		display = "r";
		score = 2.0;
		move = false;
	}

	public double getScore() {
		return score;
	}
}
