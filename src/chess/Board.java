package chess;

public class Board {
	String returnLine = System.getProperty("line.separator");
	String line = "........";
	File board;

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
}
