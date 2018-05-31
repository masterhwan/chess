package chess;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import piece.Pawn;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void create() throws Exception {
		Pawn white = new Pawn(Pawn.WHITE_COLOR);
		board.addWhitePawn(white);
		assertEquals(1, board.whitePawnSize());
		assertEquals(white, board.findWhitePawn(0));

		Pawn black = new Pawn(Pawn.BLACK_COLOR);
		board.addBlackPawn(black);
		assertEquals(1, board.blackPawnSize());
		assertEquals(black, board.findBlackPawn(0));
	}

	@Test
	public void boardInitialize() throws Exception {
		board.initialize();
		assertEquals(8, board.whitePawnSize());
		assertEquals(8, board.blackPawnSize());
		assertEquals("pppppppp", board.getWhitePawnsResult());
		assertEquals("PPPPPPPP", board.getBlackPawnsResult());
	}

	@Test
	public void BoardPrint() throws Exception {
		assertEquals("........\n" + "PPPPPPPP\n" + "........\n" + "........\n" + "........\n" + "........\n"
				+ "pppppppp\n" + "........", board.print());
	}
}
