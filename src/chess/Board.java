package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Pawn;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........" + returnLine;
	File board;
	List<Pawn> pawns = new ArrayList<>();

	public Board() {
		createBoard();
	}

	private void createBoard() {
		File file = new File(8);
		board = file.getFile();
	}

	public Object draw() {
		return board.show();
	}

	public void add(Pawn pawn) {
		pawns.add(pawn);
	}

	public int size() {
		return pawns.size();
	}

	public Pawn findPawn(int i) {
		return pawns.get(i);
	}

	public void initialize() {
		addWhitePawns();
		addBlackPawns();
	}

	private void addBlackPawns() {
		for (int i = 0; i < 8; i++) {
			pawns.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
		}
	}

	private void addWhitePawns() {
		for (int i = 0; i < 8; i++) {
			pawns.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
		}
	}

	public String print() {
		initialize();
		StringBuffer bf = new StringBuffer();
		bf.append(line);
		bf.append(addBlackPawnRepresentation());
		bf.append(line);
		bf.append(line);
		bf.append(line);
		bf.append(line);
		bf.append(addWhitePawnRepresentation());
		bf.append(line);
		return bf.toString();
	}

	private String addWhitePawnRepresentation() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			bf.append(pawns.get(i).getRepresentation());
		}
		return bf.toString() + returnLine;
	}

	private String addBlackPawnRepresentation() {
		StringBuffer bf = new StringBuffer();
		for (int i = 15; i >= 8; i--) {
			bf.append(pawns.get(i).getRepresentation());
		}
		return bf.toString() + returnLine;
	}
}
