package piece;

public class WhiteKnight {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhiteKnight() {
		color = "white";
		name = "knight";
		display = "n";
		score = 2.5;
		move = false;
	}

	public String getDisplay() {
		return display;
	}
}
