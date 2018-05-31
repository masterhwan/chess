package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Piece;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	File board;
	List<Piece> blackPawns = new ArrayList<>();
	List<Piece> whitePawns = new ArrayList<>();

	public Board() {
		createBoard();
	}

	private void createBoard() {
		File file = new File(8);
		board = file.getFile();
	}

	public String draw() {
		return board.show();
	}

	public void initialize() {
		addWhitePawns();
		addBlackPawns();
	}

	private void addBlackPawns() {
		for (int i = 0; i < 8; i++) {
			blackPawns.add(Piece.createBlackPawn());
		}
	}

	private void addWhitePawns() {
		for (int i = 0; i < 8; i++) {
			whitePawns.add(Piece.createWhitePawn());
		}
	}

	public String print() {
		initialize();
		StringBuffer bf = new StringBuffer();
		bf.append(line + returnLine);
		bf.append(getBlackPawnsResult() + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(line + returnLine);
		bf.append(getWhitePawnsResult() + returnLine);
		bf.append(line);
		return bf.toString();
	}

	public String getWhitePawnsResult() {
		Piece pawn;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			pawn = whitePawns.get(i);
			bf.append(pawn.getRepresentation());
		}
		return bf.toString();
	}

	public String getBlackPawnsResult() {
		Piece pawn;
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			pawn = blackPawns.get(i);
			bf.append(pawn.getRepresentation());
		}
		return bf.toString();
	}

	public Piece findBlackPawn(int index) {
		return blackPawns.get(index);
	}

	public Piece findWhitePawn(int index) {
		return whitePawns.get(index);
	}

	public int blackPawnSize() {
		return blackPawns.size();
	}

	public void addBlackPawn(Piece pawn) {
		blackPawns.add(pawn);
	}

	public void addWhitePawn(Piece pawn) {
		whitePawns.add(pawn);
	}

	public int whitePawnSize() {
		return whitePawns.size();
	}
}
