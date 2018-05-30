package piece;

public class WhiteKing {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhiteKing() {
		color = "white";
		name = "king";
		display = "k";
		score = 0;
		move = false;
	}

	public double getScore() {
		return score;
	}

	public String getDisplay() {
		return display;
	}

}
