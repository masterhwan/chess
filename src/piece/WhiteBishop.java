package piece;

public class WhiteBishop {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhiteBishop() {
		color = "white";
		name = "bishop";
		display = "b";
		score = '3';
		move = false;
	}

	public String getBishopName() {
		return name;
	}

	public String getDisplay() {
		return display;
	}

}
