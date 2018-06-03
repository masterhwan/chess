package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class Board {
	private String returnLine = System.getProperty("line.separator");
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

	public String showBoard() {
		return print();
	}

	private String print() {
		StringBuffer bf = new StringBuffer();
		for (int i = 7; i >= 0; i--) {
			bf.append(ranks.get(i).getRankRepresentation() + returnLine);
		}
		return bf.toString();
	}

	public int pieceCount() {
		int size = 0;
		for (Rank index : ranks) {
			size += index.size();
		}
		return size;
	}

	public Piece findPiece(String inputPosition) {
		Position position = new Position(inputPosition);
		return findRank(ranks.get(position.getYIndex()), position.getXIndex());
	}

	private Piece findRank(Rank rank, int xpos) {
		return rank.findPiece(xpos);
	}

	public void move(String inputPosition, Piece piece) {
		Position position = new Position(inputPosition);
		setPiece(ranks.get(position.getYIndex()), position.getXIndex(), piece);
	}

	private void setPiece(Rank rank, int xpos, Piece piece) {
		rank.setPiece(xpos, piece);
	}

	public double caculcatePoint(Color color) {
		double point = 0;
		for (Rank index : ranks) {
			point += index.getPoint(color);
		}
		return point;
	}

	public int countPieceByColorAndType(Color color, Type type) {
		int count = 0;
		for (Rank index : ranks) {
			count += index.getPieceCount(color, type);
		}
		return count;
	}

	public void move(Position position, Piece piece) {
		ranks.get(position.getYIndex()).setPiece(position.getXIndex(), piece);
	}

	public void move(String sourceposition, String targetposition) {
		Position sourcePosition = new Position(sourceposition);
		Position targetPosition = new Position(targetposition);

		Piece piece = findPiece(sourcePosition);
		piece.setPosition(targetPosition);
		setPiece(ranks.get(targetPosition.getYIndex()), targetPosition.getXIndex(), piece);
		setBlank(ranks.get(sourcePosition.getYIndex()), sourcePosition.getXIndex(),
				Piece.createBlank(new Position(sourcePosition.getX(), sourcePosition.getY())));
	}

	private void setBlank(Rank rank, int xpos, Piece piece) {
		rank.setPiece(xpos, piece);
	}

	private Piece findPiece(Position sourcePosition) {
		return findRank(ranks.get(sourcePosition.getYIndex()), sourcePosition.getXIndex());
	}

}
