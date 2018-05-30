package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	private String returnLine = System.getProperty("line.separator");
	private String emptyLine = "........";

	private String blackSpectialLine = "RNBQKBNR";
	private String blakcPawnLine = "PPPPPPPP";

	private String whitePawnLine = "pppppppp";
	private String whiteSpectialLine = "rnbqkbnr";

	Board board = new Board();

	@Test
	public void drawTest() {
		assertEquals(blackSpectialLine + returnLine + blakcPawnLine + returnLine + emptyLine + returnLine + emptyLine
				+ returnLine + emptyLine + returnLine + emptyLine + returnLine + whitePawnLine + returnLine
				+ whiteSpectialLine + returnLine, board.draw());
	}
}
