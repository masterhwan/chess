package piece;

public class BlackPawn {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackPawn() {
		color = "black";
		name = "pawn";
		display = "P";
		score = 1;
		move = true;
	}

	public String getColar() {
		return color;
	}

}
