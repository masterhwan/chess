package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class Rank {

	private List<Piece> pieces = new ArrayList<>();

	public void createBlackPiecesRank() {
		createBlackPieces();
	}

	private void createBlackPieces() {
		pieces.add(Piece.createBlackRook());
		pieces.add(Piece.createBlackKnight());
		pieces.add(Piece.createBlackBishop());
		pieces.add(Piece.createBlackQueen());
		pieces.add(Piece.createBlackKing());
		pieces.add(Piece.createBlackBishop());
		pieces.add(Piece.createBlackKnight());
		pieces.add(Piece.createBlackRook());
	}

	public void createWhitePiecesRank() {
		createWhitePieces();
	}

	private void createWhitePieces() {
		pieces.add(Piece.createWhiteRook());
		pieces.add(Piece.createWhiteKnight());
		pieces.add(Piece.createWhiteBishop());
		pieces.add(Piece.createWhiteQueen());
		pieces.add(Piece.createWhiteKing());
		pieces.add(Piece.createWhiteBishop());
		pieces.add(Piece.createWhiteKnight());
		pieces.add(Piece.createWhiteRook());
	}

	public void createBlackPawnRank() {
		createPawns(Color.BLACK);
	}

	public void createWhitePawnRank() {
		createPawns(Color.WHITE);
	}

	private void createPawns(Color color) {
		if (color.equals(Color.WHITE)) {
			createWhitePawn();
			return;
		}
		createBlackPawn();
	}

	public void createBlankRank() {
		createBlank();
	}

	private void createBlank() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createBlank());
		}
	}

	public int size() {
		return pieces.size();
	}

	private void createBlackPawn() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createBlackPawn());
		}
	}

	private void createWhitePawn() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createWhitePawn());
		}
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
			count += isPiece(index, color, type);
		}
		return count;
	}

	private int isPiece(Piece index, Color color, Type type) {
		if (index.getColor().equals(color) && index.getType().equals(type)) {
			return 1;
		}
		return 0;
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

	public double findPiece(Color color) {
		double point = 0;
		for (Piece index : pieces) {
			point += index.getPoint(color);
		}
		return point;
	}

	public boolean isHavePawn(Color color, Type type) {
		return false;
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
}
