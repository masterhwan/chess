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
import piece.Position;
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
		rank.addPiece(Rook.createWhite(new Position(1, y)));
		rank.addPiece(Knight.createWhite(new Position(2, y)));
		rank.addPiece(Bishop.createWhite(new Position(3, y)));
		rank.addPiece(Queen.createWhite(new Position(4, y)));
		rank.addPiece(King.createWhite(new Position(5, y)));
		rank.addPiece(Bishop.createWhite(new Position(6, y)));
		rank.addPiece(Knight.createWhite(new Position(7, y)));
		rank.addPiece(Rook.createWhite(new Position(8, y)));
		return rank;
	}

	public static Rank initializeWhitePawns(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Pawn.createWhite(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlankLine(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Blank.create(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlackPawns(int y) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.addPiece(Pawn.createBlack(new Position(i + 1, y)));
		}
		return rank;
	}

	public static Rank initializeBlackPieces(int y) {
		Rank rank = new Rank();
		rank.addPiece(Rook.createBlack(new Position(1, y)));
		rank.addPiece(Knight.createBlack(new Position(2, y)));
		rank.addPiece(Bishop.createBlack(new Position(3, y)));
		rank.addPiece(Queen.createBlack(new Position(4, y)));
		rank.addPiece(King.createBlack(new Position(5, y)));
		rank.addPiece(Bishop.createBlack(new Position(6, y)));
		rank.addPiece(Knight.createBlack(new Position(7, y)));
		rank.addPiece(Rook.createBlack(new Position(8, y)));
		return rank;
	}

	private void addPiece(Piece piece) {
		pieces.add(piece);
	}

	public ArrayList<Piece> findPieceByColor(Color color) {
		ArrayList<Piece> piecesByColor = new ArrayList<>();
		for (Piece index : pieces) {
			index.findPieceByColor(color, piecesByColor);
		}
		return piecesByColor;
	}
}
