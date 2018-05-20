package chess;

public class BlackBishop {
	private String color;
	private String name;
	private String display;
	private double score;
	private boolean move;

	public BlackBishop() {
		color = "black";
		name = "bishop";
		display = "B";
		score = '3';
		move = false;
	}

	public String getBishopName() {
		return name;
	}
}
