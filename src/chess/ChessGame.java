package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.Piece.Color;

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
}
