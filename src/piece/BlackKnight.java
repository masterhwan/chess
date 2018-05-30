package piece;

public class BlackKnight {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackKnight() {
		color = "black";
		name = "knight";
		display = "N";
		score = 2.5;
		move = false;
	}

	public String getDisplay() {
		return display;
	}

}
