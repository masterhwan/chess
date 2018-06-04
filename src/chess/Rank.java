package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import piece.Bishop;
import piece.Blank;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;
import piece.Queen;
import piece.Rook;

public class Rank {

	private List<Piece> pieces = new ArrayList<>();

	public int size() {
		return pieces.size();
	}

	public String getRankRepresentation() {
		return getRepresentaion();
	}

	private String getRepresentaion() {
		StringBuffer bf = new StringBuffer();
		for (Piece index : pieces) {
			bf.append(index.getRepresentation());
		}
		return bf.toString();
	}

	public int getPieceCount(Color color, Type type) {
		int count = 0;
		for (Piece index : pieces) {
			if (index.isPiece(color, type)) {
				count++;
			}
		}
		return count;
	}

	public Piece getFindPiece(int xPos) {
		return pieces.get(xPos);
	}

	public void setPiece(int xPos, Piece piece) {
		pieces.set(xPos, piece);
	}

	public Piece findPiece(int xpos) {
		return pieces.get(xpos);
	}

	public void sortLowToHigh() {
		Collections.sort(pieces, new Comparator<Piece>() {
			@Override
			public int compare(Piece p1, Piece p2) {
				if (p1.getPoint() < p2.getPoint()) {
					return -1;
				}
				return 0;
			}

		});
	}

	public void sortHighToLow() {
		Collections.sort(pieces, new Comparator<Piece>() {
			@Override
			public int compare(Piece p1, Piece p2) {
				if (p1.getPoint() > p2.getPoint()) {
					return -1;
				}
				return 0;
			}

		});
	}

	public static Rank initializeWhitePieces(int y) {
		Rank rank = new Rank();
		rank.addPiece(Rook.createWhiteRook(new Position(1, y)));
		rank.addPiece(Knight.createWhiteKnight(new Position(2, y)));
		rank.addPiece(Bishop.createWhiteBishop(new Position(3, y)));
		rank.addPiece(Queen.createWhiteQueen(new Position(4, y)));
		rank.addPiece(King.createWhiteKing(new Position(5, y)));
		rank.addPiece(Bishop.createWhiteBishop(new Position(6, y)));
		rank.addPiece(Knight.createWhiteKnight(new Position(7, y)));
		rank.addPiece(Rook.createWhiteRook(new Position(8, y)));
		return rank;
	}

	private void addPiece(Piece piece) {
		pieces.add(piece);
	}

	public static Rank initializeWhitePawns(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Pawn.createWhitePawn(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlankLine(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Blank.createBlank(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlackPawns(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Pawn.createBlackPawn(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlackPieces(int y) {
		Rank rank = new Rank();
		rank.addPiece(Rook.createBlackRook(new Position(1, y)));
		rank.addPiece(Knight.createBlackKnight(new Position(2, y)));
		rank.addPiece(Bishop.createBlackBishop(new Position(3, y)));
		rank.addPiece(Queen.createBlackQueen(new Position(4, y)));
		rank.addPiece(King.createBlackKing(new Position(5, y)));
		rank.addPiece(Bishop.createBlackBishop(new Position(6, y)));
		rank.addPiece(Knight.createBlackKnight(new Position(7, y)));
		rank.addPiece(Rook.createBlackRook(new Position(8, y)));
		return rank;
	}

	public ArrayList<Piece> findPieceByColor(Color color) {
		ArrayList<Piece> piecesByColor = new ArrayList<>();
		for (Piece index : pieces) {
			index.findPieceByColor(color, piecesByColor);
		}
		return piecesByColor;
	}

	public double getPoint(List<Piece> pieces) {
		double point = 0;
		for (Piece index : pieces) {
			point += index.getPoint();
		}
		return point;
	}
}
