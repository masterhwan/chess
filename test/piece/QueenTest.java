package piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {
	@Test
	public void moveBlackQueen() throws Exception {
		BlackQueen bq = new BlackQueen();
		assertFalse(bq.isMove());
	}

	@Test
	public void moveWhiteQueen() throws Exception {
		WhiteQueen wq = new WhiteQueen();
		assertFalse(wq.isMove());
	}
}
