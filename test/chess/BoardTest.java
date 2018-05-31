package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Pawn;

public class BoardTest {

	private String returnLine = System.getProperty("line.separator");
	private String emptyLine = "........";

	private String blackSpectialLine = "RNBQKBNR";
	private String blakcPawnLine = "PPPPPPPP";

	private String whitePawnLine = "pppppppp";
	private String whiteSpectialLine = "rnbqkbnr";

	Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void drawTest() {
		assertEquals(blackSpectialLine + returnLine + blakcPawnLine + returnLine + emptyLine + returnLine + emptyLine
				+ returnLine + emptyLine + returnLine + emptyLine + returnLine + whitePawnLine + returnLine
				+ whiteSpectialLine + returnLine, board.draw());
	}

	@Test
	public void create() throws Exception {
		Pawn white = new Pawn(Pawn.WHITE_COLOR);
		addWhitePawn(white);

		Pawn black = new Pawn(Pawn.BLACK_COLOR);
		addBlackPawn(black);
	}

	private void addBlackPawn(Pawn black) {
		board.add(black);
		assertEquals(2, board.size());
		assertEquals(black, board.findPawn(1));
	}

	private void addWhitePawn(Pawn white) {
		board.add(white);
		assertEquals(1, board.size());
		assertEquals(white, board.findPawn(0));
	}

	@Test
	public void boardInitialize() throws Exception {
		board.initialize();
		assertEquals(16, board.size());
	}

	@Test
	public void BoardPrint() throws Exception {
		assertEquals("........\n" + "PPPPPPPP\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "pppppppp\n" + "........\n", board.print());
	}
}
