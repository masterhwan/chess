package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import piece.Piece;

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
}
