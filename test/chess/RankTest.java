package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RankTest {
	Rank rank;

	@Before
	public void setUp() {
		rank = new Rank();
	}

	@Test
	public void getRankCount() throws Exception {
		rank.drawSpecialBlackPieces();
		assertEquals((int) 8, rank.getRankCount());
	}

	@Test
	public void showRanks() throws Exception {
		rank.drawSpecialBlackPieces();
		assertEquals("RNBQKBNR\n", rank.show());
	}
}
