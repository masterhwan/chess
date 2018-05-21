package chess;

public class BlackQueen {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackQueen() {
		color = "black";
		name = "queen";
		display = "Q";
		score = '4';
		move = false;
	}

	public boolean isMove() {
		return move;
	}

}
