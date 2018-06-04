package chess;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void initialize() throws Exception {
		ChessView chessView = new ChessView(board.getRanks());
		board.initialize();
		System.out.println(chessView.view());
	}
}
