package chess;

import java.util.ArrayList;
import java.util.List;

import Exception.InvalidMovePositionException;
import piece.Blank;
import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;
import piece.Position;

public class Board {
	private List<Rank> ranks = new ArrayList<>();

	public void emptyInitialize() {
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.initializeBlankLine(i));
		}
	}

	public void initialize() {
		ranks.add(Rank.initializeWhitePieces(1));
		ranks.add(Rank.initializeWhitePawns(2));
		ranks.add(Rank.initializeBlankLine(3));
		ranks.add(Rank.initializeBlankLine(4));
		ranks.add(Rank.initializeBlankLine(5));
		ranks.add(Rank.initializeBlankLine(6));
		ranks.add(Rank.initializeBlackPawns(7));
		ranks.add(Rank.initializeBlackPieces(8));
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	public void move(Position source, Position target) {
		if (source.equals(target)) {
			throw new InvalidMovePositionException("제자리 이동 X");
		}
		Piece piece = findPiece(source);
		piece.move(findPiece(target));
		replacePiece(piece);
		replacePiece(Blank.create(source));
	}

	public double caculcatePoint(Color color) {
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

	public Piece findPiece(Position inputPosition) {
		Piece piece = findRank(inputPosition.getYIndex()).findPiece(inputPosition.getXIndex());
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

	public void replacePiece(Piece piece) {
		findRank(piece.getYIndex()).setPiece(piece.getXIndex(), piece);
	}
}
