package piece;

public class WhiteQueen {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public WhiteQueen() {
		color = "white";
		name = "queen";
		display = "q";
		score = '4';
		move = false;
	}

	public boolean isMove() {
		return move;
	}

	public String getDisplay() {
		return display;
	}

}
