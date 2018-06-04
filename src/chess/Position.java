package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import piece.Piece.Type;

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

	public List<Position> getNeighborhoodColumn() {
		return Arrays.asList(new Position(this.x, this.y + 1), new Position(this.x, this.y - 1));
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

	private List<Position> getKingMovement() {
		return Arrays.asList(new Position(this.x - 1, this.y + 1), new Position(this.x, this.y + 1),
				new Position(this.x + 1, this.y + 1), new Position(this.x - 1, this.y),
				new Position(this.x + 1, this.y), new Position(this.x - 1, this.y - 1),
				new Position(this.x, this.y - 1), new Position(this.x + 1, this.y - 1));
	}

	public List<Position> getPieceMovementAble(Type type) {
		if (type == Type.KING) {
			return getKingMovement();
		} else if (type == Type.QUEEN) {
			return getQueenMovement();
		}
		return Arrays.asList();
	}

	private List<Position> getQueenMovement() {
		List<Position> positions = new ArrayList<>();
		positions.addAll(decreaseXHorizeMovement(this.x - 1));
		positions.addAll(increaseXHorizeMovement(this.x + 1));
		positions.addAll(decreaseYVerticalMovement(this.y - 1));
		positions.addAll(increaseYVerticalMovement(this.y + 1));

		positions.addAll(decreaseXDecreaseYDiagnalMovement(this.x - 1, this.y - 1));
		// positions.addAll(decreaseXIncreaseYDiagnalMovement(this.x - 1, this.y + 1));
		// positions.addAll(IncreaseXDecreaseYDiagnalMovement(this.x - 1, this.y - 1));
		// positions.addAll(IncreaseXIncreaseYDiagnalMovement(this.x - 1, this.y - 1));
		return positions;
	}

	private List<Position> IncreaseXIncreaseYDiagnalMovement(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Position> IncreaseXDecreaseYDiagnalMovement(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Position> decreaseXIncreaseYDiagnalMovement(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Position> decreaseXDecreaseYDiagnalMovement(int x, int y) {
		List<Position> positions = new ArrayList<>();
		if (x == 0 || y == 0) {
			return Arrays.asList();
		} else if (x < 0 && y < 0) {
			return Arrays.asList(new Position(x, y));
		}
		positions.add(new Position(x, y));
		positions.addAll(decreaseXDecreaseYDiagnalMovement(x - 1, y - 1));
		return positions;
	}

	private List<Position> increaseYVerticalMovement(int y) {
		List<Position> positions = new ArrayList<>();
		if (y == 8) {
			return Arrays.asList(new Position(this.x, y));
		}
		positions.add(new Position(this.x, y));
		positions.addAll(increaseYVerticalMovement(y + 1));
		return positions;
	}

	private List<Position> decreaseYVerticalMovement(int y) {
		List<Position> positions = new ArrayList<>();
		if (y < 0) {
			return Arrays.asList(new Position(this.x, y));
		} else if (y == 0) {
			return Arrays.asList();
		}
		positions.add(new Position(this.x, y));
		positions.addAll(increaseYVerticalMovement(y - 1));
		return positions;
	}

	private List<Position> increaseXHorizeMovement(int x) {
		List<Position> positions = new ArrayList<>();
		if (x == 8) {
			return Arrays.asList(new Position(x, this.y));
		}
		positions.add(new Position(x, this.y));
		positions.addAll(increaseXHorizeMovement(x + 1));
		return positions;
	}

	private List<Position> decreaseXHorizeMovement(int x) {
		List<Position> positions = new ArrayList<>();
		if (x < 0) {
			return Arrays.asList(new Position(x, this.y));
		} else if (x == 0) {
			return Arrays.asList();
		}
		positions.add(new Position(x, this.y));
		positions.addAll(decreaseXHorizeMovement(x - 1));
		return positions;
	}
}
