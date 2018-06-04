package piece;

import java.util.ArrayList;
import java.util.List;

import chess.Position;

public class Piece {
	public enum Color {
		BLACK, WHITE, NOCOLOR;
	}

	public enum Type {
		PAWN('p', 1), ROOK('r', 5), KNIGHT('n', 2.5), BISHOP('b', 3), QUEEN('q', 9), KING('k', 0), NO_PIECE('.', 0);

		private char representation;
		private double point;

		private Type(char representation, double point) {
			this.representation = representation;
			this.point = point;
		}

		public char getWhiteRepresentation() {
			return representation;
		}

		public char getBlackRepresentation() {
			return Character.toUpperCase(representation);
		}

		public double getPoint() {
			return point;
		}
	}

	private Color color;
	private Type type;
	private Position position;

	public Piece(Color color, Type type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
	}

	public boolean isPiece(Color color, Type type) {
		return matchColor(color) && matchType(type);
	}

	private boolean matchColor(Color color) {
		return this.color == color;
	}

	public boolean matchType(Type type) {
		return this.type == type;
	}

	public Color getColor() {
		return color;
	}

	public char getRepresentation() {
		return isBlack() ? this.type.getBlackRepresentation() : this.type.getWhiteRepresentation();
	}

	public Type getType() {
		return type;
	}

	public Position getPosition() {
		return position;
	}

	public double getPoint() {
		return this.type.getPoint();
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}

	public boolean isWhite() {
		return this.color == Color.WHITE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + ", position=" + position + "]";
	}

	public void setPosition(Position targetPosition) {
		this.position = targetPosition;
	}

	public void findPieceByColor(Color color, ArrayList<Piece> piecesByColor) {
		if (matchColor(color)) {
			piecesByColor.add(this);
		}
	}

	public double getPoint(List<Piece> pieces) {
		if (!matchType(Type.PAWN)) {
			return getPoint();
		}
		List<Position> positions = this.position.getNeighborhoodColumn();
		for (Position index : positions) {
			if (pieces.contains(Pawn.create(this.color, index))) {
				return getPoint() - 0.5;
			}
			System.out.println("\n");
		}
		return getPoint();
	}
}
