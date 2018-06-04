package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class ChessGame {

	private List<Rank> ranks;

	public ChessGame(List<Rank> ranks) {
		this.ranks = ranks;
	}

	public double calculatePoint(Color color) {
		double point = 0;
		List<Piece> pieces = findPieceByColor(color);
		for (Piece index : pieces) {
			point += index.getPoint(pieces);
		}
		return point;
	}

	private List<Piece> findPieceByColor(Color color) {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		for (Rank index : ranks) {
			pieces.addAll(index.findPieceByColor(color));
		}
		return pieces;
	}

	public void move(Position position, Piece piece) {
		ranks.get(position.getYIndex()).setPiece(position.getXIndex(), piece);
	}

	public void move(String sourcePosition, String target_position) {
		Piece piece = findPiece(sourcePosition);
		movePiece(target_position, piece);
		replaceBlank(sourcePosition, Piece.createBlank(new Position(sourcePosition)));
	}

	private void replaceBlank(String sourcePosition, Piece piece) {
		Position position = new Position(sourcePosition);
		ranks.get(position.getYIndex()).setPiece(position.getXIndex(), Piece.createBlank(position));
	}

	private void movePiece(String targetPosition, Piece piece) {
		Position position = new Position(targetPosition);
		piece.setPosition(position);
		ranks.get(position.getYIndex()).setPiece(position.getXIndex(), piece);
	}

	public Piece findPiece(String inputPosition) {
		Position position = new Position(inputPosition);
		Piece piece = findRank(position.getYIndex()).findPiece(position.getXIndex());
		return piece;
	}

	private Rank findRank(int index) {
		return ranks.get(index);
	}

	public int countPieceByColorAndType(Color color, Type type) {
		int count = 0;
		List<Piece> pieces = findPieceByColor(color);
		for (Piece index : pieces) {
			if (index.matchType(type)) {
				count++;
			}
		}
		return count;
	}
}
