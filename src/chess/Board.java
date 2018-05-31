package chess;

import java.util.ArrayList;
import java.util.List;

import piece.Pawn;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
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
}
