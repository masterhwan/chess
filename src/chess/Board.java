package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	List<File> files = new ArrayList<>(8);

	public Board() {
		createBoard();
	}

	private void createBoard() {
		for (int i = 0; i < files.size(); i++) {
			files.add(new File(i));
		}
	}

	public Object draw() {
		return new Board();
	}
}
