package chess;

import java.util.Arrays;
import java.util.List;

public class Position {

	private int x;
	private int y;

	public Position(String position) {
		this.x = position.charAt(0) - 'a' + 1;
		this.y = Character.getNumericValue(position.charAt(1));
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXIndex() {
		return x - 1;
	}

	public int getYIndex() {
		return y - 1;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [xPos=" + x + ", yPos=" + y + "]";
	}

	public List<Position> getColumnNeighbors() {
		return Arrays.asList(new Position(getX(), getY() - 1), new Position(getX(), getY() + 1));
	}

	public List<Position> getNeighborhoodColumn() {
		return Arrays.asList(new Position(this.x, this.y + 1), new Position(this.x, this.y - 1));
	}

}
