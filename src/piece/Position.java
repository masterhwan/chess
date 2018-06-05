package piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import piece.Piece.Color;

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

	public List<Position> getKingMovementAble() {
		return getKingMovement();
	}

	public List<Position> getQueenMovementAble() {
		return getQueenMovement();
	}

	private List<Position> getKingMovement() {
		List<Position> position = new ArrayList<>();
		List<Direction> directions = Direction.everyDirection();
		for (Direction index : directions) {
			position.add(new Position(this.x + index.getX(), this.y + index.getY()));
		}
		return position;
	}

	private List<Position> getQueenMovement() {
		List<Position> positions = new ArrayList<>();
		positions.addAll(decreaseXHorizeMovement(this.x - 1));
		positions.addAll(increaseXHorizeMovement(this.x + 1));
		positions.addAll(decreaseYVerticalMovement(this.y - 1));
		positions.addAll(increaseYVerticalMovement(this.y + 1));

		positions.addAll(decreaseXDecreaseYDiagnalMovement(this.x - 1, this.y - 1));
		positions.addAll(decreaseXIncreaseYDiagnalMovement(this.x - 1, this.y + 1));
		positions.addAll(IncreaseXDecreaseYDiagnalMovement(this.x + 1, this.y - 1));
		positions.addAll(IncreaseXIncreaseYDiagnalMovement(this.x + 1, this.y + 1));
		return positions;
	}

	private List<Position> IncreaseXIncreaseYDiagnalMovement(int x, int y) {
		List<Position> positions = new ArrayList<>();
		if (x == 8 || y == 8) {
			return Arrays.asList(new Position(x, y));
		}
		positions.add(new Position(x, y));
		positions.addAll(IncreaseXIncreaseYDiagnalMovement(x + 1, y + 1));
		return positions;
	}

	private List<Position> IncreaseXDecreaseYDiagnalMovement(int x, int y) {
		List<Position> positions = new ArrayList<>();
		if (x == 8 || y == 1) {
			return Arrays.asList(new Position(x, y));
		}
		positions.add(new Position(x, y));
		positions.addAll(IncreaseXDecreaseYDiagnalMovement(x + 1, y - 1));
		return positions;
	}

	private List<Position> decreaseXIncreaseYDiagnalMovement(int x, int y) {
		List<Position> positions = new ArrayList<>();
		if (x == 1 || y == 8) {
			return Arrays.asList(new Position(x, y));
		}
		positions.add(new Position(x, y));
		positions.addAll(decreaseXIncreaseYDiagnalMovement(x - 1, y + 1));
		return positions;
	}

	private List<Position> decreaseXDecreaseYDiagnalMovement(int x, int y) {
		List<Position> positions = new ArrayList<>();
		if (x == 1 || y == 1) {
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
		if (y == 1) {
			return Arrays.asList(new Position(this.x, y));
		}
		positions.add(new Position(this.x, y));
		positions.addAll(decreaseYVerticalMovement(y - 1));
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
		if (x == 0) {
			return Arrays.asList(new Position(x, this.y));
		}
		positions.add(new Position(x, this.y));
		positions.addAll(decreaseXHorizeMovement(x - 1));
		return positions;
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

	public List<Position> getBishopMovementAble() {
		List<Position> positions = new ArrayList<>();
		positions.addAll(decreaseXDecreaseYDiagnalMovement(this.x - 1, this.y - 1));
		positions.addAll(decreaseXIncreaseYDiagnalMovement(this.x - 1, this.y + 1));
		positions.addAll(IncreaseXDecreaseYDiagnalMovement(this.x + 1, this.y - 1));
		positions.addAll(IncreaseXIncreaseYDiagnalMovement(this.x + 1, this.y + 1));
		return positions;
	}

	public List<Position> getKnightMovementAble() {
		List<Position> position = new ArrayList<>();
		List<Direction> directions = Direction.knightDirection();
		for (Direction index : directions) {
			position.add(new Position(this.x + index.getX(), this.y + index.getY()));
		}
		return position;
	}

	public List<Position> getRookMovementAble() {
		List<Position> positions = new ArrayList<>();
		positions.addAll(decreaseXHorizeMovement(this.x - 1));
		positions.addAll(increaseXHorizeMovement(this.x + 1));
		positions.addAll(decreaseYVerticalMovement(this.y - 1));
		positions.addAll(increaseYVerticalMovement(this.y + 1));
		return positions;
	}

	public List<Position> getPawnMovementAble(Color color) {
		if (color == Color.BLACK) {
			return blackPawnMovement();
		}
		return whitePawnMovement();
	}

	private List<Position> whitePawnMovement() {
		List<Position> position = new ArrayList<>();
		List<Direction> directions = Direction.whitePawnDirection();
		for (Direction index : directions) {
			position.add(new Position(this.x + index.getX(), this.y + index.getY()));
		}
		return position;
	}

	private List<Position> blackPawnMovement() {
		List<Position> position = new ArrayList<>();
		List<Direction> directions = Direction.blackPawnDirection();
		for (Direction index : directions) {
			position.add(new Position(this.x + index.getX(), this.y + index.getY()));
		}
		return position;
	}

}
