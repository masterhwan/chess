package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RankTest {
	@Test
	public void getRankCount() throws Exception {
		Rank rank = new Rank().createSpecialBlackPieces();
		assertEquals((int) 8, rank.getRankCount());
	}

	@Test
	public void showRanks() throws Exception {
		Rank rank = new Rank().createSpecialBlackPieces();
		assertEquals("RNBQKBNR\n", rank.show());
	}
}
