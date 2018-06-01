package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;
import piece.Piece.Color;
import piece.Piece.Type;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	List<Rank> ranks = new ArrayList<>();

	public Board() {
		initialize();
	}

	public void initialize() {
		addBlackPieceRank();
		addBlackPawnsRank();
		addBlankRank();
		addWhitePawnsRank();
		addWhitePieceRank();
	}

	private void addBlankRank() {
		Rank rank = new Rank();
		rank.createBlankRank();
		ranks.add(rank);
		ranks.add(rank);
		ranks.add(rank);
		ranks.add(rank);
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
		for (Rank index : ranks) {
			bf.append(index.getRankRepresentation() + returnLine);
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

	public int getBlackPieceCount(Type type) {
		return getCount(Color.BLACK, type);
	}

	public int getWhitePawnCount() {
		return getCount(Color.WHITE, Type.PAWN);
	}

	public int getWhitePieceCount(Type type) {
		return getCount(Color.WHITE, type);
	}

	private int getCount(Color color, Type type) {
		int count = 0;
		for (Rank index : ranks) {
			count += index.getPieceCount(color, type);
		}
		return count;
	}

	public Piece findPiece(String position) {
		char x = position.charAt(0);
		int xPos = x - 'a';
		char y = position.charAt(1);
		int yPos = 8 - Character.getNumericValue(y);
		return ranks.get(yPos).getFindPiece(xPos);
	}
}
