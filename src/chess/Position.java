package chess;

public class Position {

	private int xPos;
	private int yPos;

	public Position() {

	}

	public Position(String position) {
		char x = position.charAt(0);
		xPos = x - 'a';
		char y = position.charAt(1);
		yPos = Character.getNumericValue(y) - 1;
	}

	public int getXpos() {
		return xPos;
	}

	public int getYpos() {
		return yPos;
	}

}
