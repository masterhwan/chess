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
		addBlankRank();
		addBlankRank();
	}

	public void initialize() {
		addWhitePieceRank();
		addWhitePawnsRank();
		addBlankRank();
		addBlackPawnsRank();
		addBlackPieceRank();
	}

	private void addBlankRank() {
		for (int i = 0; i < 4; i++) {
			Rank rank = new Rank();
			rank.createBlankRank();
			ranks.add(rank);
		}
	}

	private void addWhitePieceRank() {
		Rank rank = new Rank();
		rank.createWhitePiecesRank();
		ranks.add(rank);

	}

	private void addBlackPieceRank() {
		Rank rank = new Rank();
		rank.createBlackPiecesRank();
		ranks.add(rank);
	}

	private void addBlackPawnsRank() {
		Rank rank = new Rank();
		rank.createBlackPawnRank();
		ranks.add(rank);
	}

	private void addWhitePawnsRank() {
		Rank rank = new Rank();
		rank.createWhitePawnRank();
		ranks.add(rank);
	}

	private String print() {
		StringBuffer bf = new StringBuffer();
		for (int i = 7; i >= 0; i--) {
			bf.append(ranks.get(i).getRankRepresentation() + returnLine);
		}
		return bf.toString();
	}

	public String showBoard() {
		return print();
	}

	public int pieceCount() {
		return ranks.size() * 8;
	}

	public int getBlackPawnCount() {
		return getCount(Color.BLACK, Type.PAWN);
	}

	public int getBlackRookPieceCount() {
		return getCount(Color.BLACK, Type.ROOK);
	}

	public int getBlackKnightPieceCount() {
		return getCount(Color.BLACK, Type.KNIGHT);
	}

	public int getBlackRookCBishopount() {
		return getCount(Color.BLACK, Type.BISHOP);
	}

	public int getBlackRookQueenCount() {
		return getCount(Color.BLACK, Type.QUEEN);
	}

	public int getBlackRookKingCount() {
		return getCount(Color.BLACK, Type.KING);
	}

	public int getWhitePawnCount() {
		return getCount(Color.WHITE, Type.PAWN);
	}

	public int getwhiteRookPieceCount() {
		return getCount(Color.WHITE, Type.ROOK);
	}

	public int getwhiteKnightPieceCount() {
		return getCount(Color.WHITE, Type.KNIGHT);
	}

	public int getwhiteRookCBishopount() {
		return getCount(Color.WHITE, Type.BISHOP);
	}

	public int getwhiteRookQueenCount() {
		return getCount(Color.WHITE, Type.QUEEN);
	}

	public int getwhiteRookKingCount() {
		return getCount(Color.WHITE, Type.KING);
	}

	private int getCount(Color color, Type type) {
		int count = 0;
		for (Rank index : ranks) {
			count += index.getPieceCount(color, type);
		}
		return count;
	}

	public Piece findPiece(String position) {
		Position move = new Position(position);
		return ranks.get(move.getYpos()).getFindPiece(move.getXpos());
	}

	public void move(String position, Piece piece) {
		Position move = new Position(position);

		ranks.get(move.getYpos()).setPiece(move.getXpos(), piece);
	}

}
